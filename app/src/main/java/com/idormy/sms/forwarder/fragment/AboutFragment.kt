package com.idormy.sms.forwarder.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.idormy.sms.forwarder.R
import com.idormy.sms.forwarder.core.BaseFragment
import com.idormy.sms.forwarder.core.webview.AgentWebActivity
import com.idormy.sms.forwarder.databinding.FragmentAboutBinding
import com.idormy.sms.forwarder.utils.AppUtils
import com.idormy.sms.forwarder.utils.CacheUtils
import com.idormy.sms.forwarder.utils.CommonUtils.Companion.gotoProtocol
import com.idormy.sms.forwarder.utils.CommonUtils.Companion.previewMarkdown
import com.idormy.sms.forwarder.utils.HistoryUtils
import com.idormy.sms.forwarder.utils.XToastUtils
import com.xuexiang.xaop.annotation.SingleClick
import com.xuexiang.xpage.annotation.Page
import com.xuexiang.xui.widget.actionbar.TitleBar
import com.xuexiang.xui.widget.textview.supertextview.SuperTextView
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Page(name = "关于软件")
class AboutFragment : BaseFragment<FragmentAboutBinding?>(),
    SuperTextView.OnSuperTextViewClickListener {

    override fun viewBindingInflate(
        inflater: LayoutInflater,
        container: ViewGroup,
    ): FragmentAboutBinding {
        return FragmentAboutBinding.inflate(inflater, container, false)
    }

    override fun initTitle(): TitleBar? {
        val titleBar = super.initTitle()!!.setImmersive(false)
        titleBar.setTitle(R.string.menu_about)
        return titleBar
    }

    /**
     * 初始化控件
     */
    override fun initViews() {
        binding!!.menuVersion.setLeftString(
            String.format(
                resources.getString(R.string.about_app_version),
                AppUtils.getAppVersionName()
            )
        )
        binding!!.menuCache.setLeftString(
            String.format(
                resources.getString(R.string.about_cache_size),
                CacheUtils.getTotalCacheSize(requireContext())
            )
        )

        val dateFormat = SimpleDateFormat("yyyy", Locale.CHINA)
        val currentYear = dateFormat.format(Date())
        binding!!.copyright.text =
            java.lang.String.format(resources.getString(R.string.about_copyright), currentYear)
    }

    override fun initListeners() {
        binding!!.btnCache.setOnClickListener {
            HistoryUtils.clearPreference()
            CacheUtils.clearAllCache(requireContext())
            XToastUtils.success(R.string.about_cache_purged)
            binding!!.menuCache.setLeftString(
                String.format(
                    resources.getString(R.string.about_cache_size),
                    CacheUtils.getTotalCacheSize(requireContext())
                )
            )
        }
        binding!!.btnGithub.setOnClickListener {
            AgentWebActivity.goWeb(context, getString(R.string.url_project_github))
        }
        binding!!.btnGitee.setOnClickListener {
            AgentWebActivity.goWeb(context, getString(R.string.url_project_gitee))
        }

        binding!!.menuWechatMiniprogram.setOnSuperTextViewClickListener(this)
        binding!!.menuDonation.setOnSuperTextViewClickListener(this)
        binding!!.menuUserProtocol.setOnSuperTextViewClickListener(this)
        binding!!.menuPrivacyProtocol.setOnSuperTextViewClickListener(this)
    }

    @SingleClick
    override fun onClick(v: SuperTextView) {
        when (v.id) {
            R.id.menu_donation -> {
                previewMarkdown(
                    this,
                    getString(R.string.about_item_donation_link),
                    getString(R.string.url_donation_link),
                    false
                )
            }

            R.id.menu_user_protocol -> {
                gotoProtocol(this, isPrivacy = false, isImmersive = false)
            }

            R.id.menu_privacy_protocol -> {
                gotoProtocol(this, isPrivacy = true, isImmersive = false)
            }
        }
    }
}