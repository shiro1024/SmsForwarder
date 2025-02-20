package com.idormy.sms.forwarder.fragment.action

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.work.Data
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.google.gson.Gson
import com.idormy.sms.forwarder.R
import com.idormy.sms.forwarder.core.BaseFragment
import com.idormy.sms.forwarder.databinding.FragmentTasksActionResendBinding
import com.idormy.sms.forwarder.entity.MsgInfo
import com.idormy.sms.forwarder.entity.TaskSetting
import com.idormy.sms.forwarder.entity.action.ResendSetting
import com.idormy.sms.forwarder.utils.KEY_BACK_DATA_ACTION
import com.idormy.sms.forwarder.utils.KEY_BACK_DESCRIPTION_ACTION
import com.idormy.sms.forwarder.utils.KEY_EVENT_DATA_ACTION
import com.idormy.sms.forwarder.utils.Log
import com.idormy.sms.forwarder.utils.TASK_ACTION_RESEND
import com.idormy.sms.forwarder.utils.TaskWorker
import com.idormy.sms.forwarder.utils.XToastUtils
import com.idormy.sms.forwarder.workers.ActionWorker
import com.xuexiang.xaop.annotation.SingleClick
import com.xuexiang.xpage.annotation.Page
import com.xuexiang.xrouter.annotation.AutoWired
import com.xuexiang.xrouter.launcher.XRouter
import com.xuexiang.xui.utils.CountDownButtonHelper
import com.xuexiang.xui.widget.actionbar.TitleBar
import java.util.Date

@Page(name = "Resend")
@Suppress("PrivatePropertyName", "DEPRECATION")
class ResendFragment : BaseFragment<FragmentTasksActionResendBinding?>(), View.OnClickListener {

    private val TAG: String = ResendFragment::class.java.simpleName
    private var titleBar: TitleBar? = null
    private var mCountDownHelper: CountDownButtonHelper? = null

    @JvmField
    @AutoWired(name = KEY_EVENT_DATA_ACTION)
    var eventData: String? = null

    override fun initArgs() {
        XRouter.getInstance().inject(this)
    }

    override fun viewBindingInflate(
        inflater: LayoutInflater,
        container: ViewGroup,
    ): FragmentTasksActionResendBinding {
        return FragmentTasksActionResendBinding.inflate(inflater, container, false)
    }

    override fun initTitle(): TitleBar? {
        titleBar = super.initTitle()!!.setImmersive(false).setTitle(R.string.task_resend)
        return titleBar
    }

    /**
     * 初始化控件
     */
    override fun initViews() {
        //测试按钮增加倒计时，避免重复点击
        mCountDownHelper = CountDownButtonHelper(binding!!.btnTest, 1)
        mCountDownHelper!!.setOnCountDownListener(object :
            CountDownButtonHelper.OnCountDownListener {
            override fun onCountDown(time: Int) {
                binding!!.btnTest.text = String.format(getString(R.string.seconds_n), time)
            }

            override fun onFinished() {
                binding!!.btnTest.text = getString(R.string.test)
            }
        })

        var settingVo = ResendSetting(getString(R.string.task_resend_tips), 1, listOf(0))
        Log.d(TAG, "initViews eventData:$eventData")
        if (eventData != null) {
            settingVo = Gson().fromJson(eventData, ResendSetting::class.java)
            Log.d(TAG, "initViews settingVo:$settingVo")
        }
        binding!!.xsbHours.setDefaultValue(settingVo.hours)
        settingVo.statusList.forEach { item ->
            when (item) {
                0 -> binding!!.scbFailed.isChecked = true
                1 -> binding!!.scbProcessing.isChecked = true
                2 -> binding!!.scbSuccess.isChecked = true
            }
        }
    }

    @SuppressLint("SetTextI18n")
    override fun initListeners() {
        binding!!.btnTest.setOnClickListener(this)
        binding!!.btnDel.setOnClickListener(this)
        binding!!.btnSave.setOnClickListener(this)
    }

    @SingleClick
    override fun onClick(v: View) {
        try {
            when (v.id) {
                R.id.btn_test -> {
                    mCountDownHelper?.start()
                    try {
                        val settingVo = checkSetting()
                        Log.d(TAG, settingVo.toString())
                        val taskAction = TaskSetting(
                            TASK_ACTION_RESEND,
                            getString(R.string.task_resend),
                            settingVo.description,
                            Gson().toJson(settingVo),
                            requestCode
                        )
                        val taskActionsJson = Gson().toJson(arrayListOf(taskAction))
                        val msgInfo = MsgInfo(
                            "task",
                            getString(R.string.task_resend),
                            settingVo.description,
                            Date(),
                            getString(R.string.task_resend)
                        )
                        val actionData = Data.Builder().putLong(TaskWorker.taskId, 0)
                            .putString(TaskWorker.taskActions, taskActionsJson)
                            .putString(TaskWorker.msgInfo, Gson().toJson(msgInfo)).build()
                        val actionRequest =
                            OneTimeWorkRequestBuilder<ActionWorker>().setInputData(actionData)
                                .build()
                        WorkManager.getInstance().enqueue(actionRequest)
                    } catch (e: Exception) {
                        mCountDownHelper?.finish()
                        e.printStackTrace()
                        Log.e(TAG, "onClick error: ${e.message}")
                        XToastUtils.error(e.message.toString(), 30000)
                    }
                    return
                }

                R.id.btn_del -> {
                    popToBack()
                    return
                }

                R.id.btn_save -> {
                    val settingVo = checkSetting()
                    val intent = Intent()
                    intent.putExtra(KEY_BACK_DESCRIPTION_ACTION, settingVo.description)
                    intent.putExtra(KEY_BACK_DATA_ACTION, Gson().toJson(settingVo))
                    setFragmentResult(TASK_ACTION_RESEND, intent)
                    popToBack()
                    return
                }
            }
        } catch (e: Exception) {
            XToastUtils.error(e.message.toString(), 30000)
            e.printStackTrace()
            Log.e(TAG, "onClick error: ${e.message}")
        }
    }

    //检查设置
    @SuppressLint("SetTextI18n")
    private fun checkSetting(): ResendSetting {
        val hours = binding!!.xsbHours.selectedNumber
        val statusList = mutableListOf<Int>()
        val statusStrList = mutableListOf<String>()
        if (binding!!.scbFailed.isChecked) {
            statusList.add(0)
            statusStrList.add(getString(R.string.failed))
        }
        if (binding!!.scbProcessing.isChecked) {
            statusList.add(1)
            statusStrList.add(getString(R.string.processing))
        }
        if (binding!!.scbSuccess.isChecked) {
            statusList.add(2)
            statusStrList.add(getString(R.string.success))
        }
        if (statusList.isEmpty()) {
            throw Exception(getString(R.string.task_resend_error))
        }
        val description = String.format(
            getString(R.string.task_resend_desc),
            hours,
            statusStrList.joinToString("/")
        )
        return ResendSetting(description, hours, statusList)
    }
}