package com.idormy.sms.forwarder.utils

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.wifi.WifiManager
import androidx.core.app.ActivityCompat
import com.google.gson.Gson
import com.idormy.sms.forwarder.App
import com.idormy.sms.forwarder.server.model.SmsSendData
import com.idormy.sms.forwarder.service.HttpServerService
import com.xuexiang.xrouter.utils.TextUtils
import com.xuexiang.xutil.XUtil
import com.xuexiang.xutil.system.DeviceUtils

@Suppress("OPT_IN_USAGE", "DeferredResultUnused", "DEPRECATION")
class SmsCommandUtils {

    companion object {

        var TAG = "SmsCommandUtils"

        //检查短信指令
        fun check(smsContent: String): Boolean {
            return smsContent.startsWith("smsf#")
        }

        //执行短信指令
        fun execute(context: Context, smsCommand: String): Boolean {
            val cmdList = smsCommand.split("#")
            Log.d(TAG, "smsCommand = $smsCommand, cmdList = $cmdList")
            if (cmdList.count() < 2) return false

            val function = cmdList[0]
            val action = cmdList[1]
            val param = if (cmdList.count() > 2) cmdList[2] else ""
            when (function) {
                "httpserver" -> {
                    Intent(context, HttpServerService::class.java).also {
                        if (action == "start") {
                            context.startService(it)
                        } else if (action == "stop") {
                            context.stopService(it)
                        }
                    }
                }

                "system" -> {
                    //判断是否已root
                    if (!DeviceUtils.isDeviceRooted()) return false

                    if (action == "reboot") {
                        DeviceUtils.reboot()
                    } else if (action == "shutdown") {
                        DeviceUtils.shutdown()
                    }
                }

                "wifi" -> {
                    val wifiManager =
                        context.applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
                    if (action == "on") {
                        wifiManager.isWifiEnabled = true
                    } else if (action == "off") {
                        wifiManager.isWifiEnabled = false
                    }
                }

                "sms" -> {
                    if (action == "send") {
                        if (TextUtils.isEmpty(param)) return false

                        try {
                            val gson = Gson()
                            val smsSendData = gson.fromJson(param, SmsSendData::class.java)
                            Log.d(TAG, smsSendData.toString())

                            //获取卡槽信息
                            if (App.SimInfoList.isEmpty()) {
                                App.SimInfoList = PhoneUtils.getSimMultiInfo()
                            }
                            Log.d(TAG, App.SimInfoList.toString())

                            //发送卡槽: 1=SIM1, 2=SIM2
                            val simSlotIndex = smsSendData.simSlot - 1
                            //TODO：取不到卡槽信息时，采用默认卡槽发送
                            val mSubscriptionId: Int =
                                App.SimInfoList[simSlotIndex]?.mSubscriptionId ?: -1

                            if (ActivityCompat.checkSelfPermission(
                                    XUtil.getContext(),
                                    Manifest.permission.SEND_SMS
                                ) != PackageManager.PERMISSION_GRANTED
                            ) {
                                return false
                            }
                            PhoneUtils.sendSms(
                                mSubscriptionId,
                                smsSendData.phoneNumbers,
                                smsSendData.msgContent
                            )
                        } catch (e: Exception) {
                            Log.e(TAG, "Parsing SMS failed: " + e.message.toString())
                        }
                    }
                }
            }

            return true
        }
    }
}