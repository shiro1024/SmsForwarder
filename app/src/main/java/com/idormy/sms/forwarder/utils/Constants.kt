package com.idormy.sms.forwarder.utils

object Worker {
    const val sendMsgInfo = "send_msg_info"
    const val updateLogs = "update_logs"
    const val rule = "rule"
    const val senderIndex = "sender_index"
    const val msgId = "msg_id"
    //const val ruleId = "rule_id"
    //const val sendLogId = "send_log_id"
    //const val sendSbnId = "send_sbn_id"
}

object TaskWorker {
    const val taskId = "task_id"
    const val task = "task"
    const val taskConditions = "task_conditions"
    const val taskActions = "task_actions"
    const val conditionType = "condition_type"
    const val msg = "msg"
    const val msgInfo = "msg_info"
    const val action = "action"
}

//数据库
const val DATABASE_NAME = "smsforwarder.db"
const val PACKAGE_NAME = "com.idormy.sms.forwarder"

//通用设置
const val SP_ENABLE_SMS = "enable_sms"

const val SP_ENABLE_PHONE = "enable_phone"
const val SP_ENABLE_CALL_TYPE_1 = "enable_call_type_1"
const val SP_ENABLE_CALL_TYPE_2 = "enable_call_type_2"
const val SP_ENABLE_CALL_TYPE_3 = "enable_call_type_3"
const val SP_ENABLE_CALL_TYPE_4 = "enable_call_type_4"
const val SP_ENABLE_CALL_TYPE_5 = "enable_call_type_5"
const val SP_ENABLE_CALL_TYPE_6 = "enable_call_type_6"

const val SP_ENABLE_APP_NOTIFY = "enable_app_notify"
const val SP_ENABLE_CANCEL_APP_NOTIFY = "enable_cancel_app_notify"
const val SP_CANCEL_EXTRA_APP_NOTIFY = "cancel_extra_app_notify_list"
const val SP_ENABLE_NOT_USER_PRESENT = "enable_not_user_present"

const val SP_ENABLE_SMS_COMMAND = "enable_sms_command"
const val SP_SMS_COMMAND_SAFE_PHONE = "sms_command_safe_phone"

const val ENABLE_LOAD_APP_LIST = "enable_load_app_list"
const val ENABLE_LOAD_USER_APP_LIST = "enable_load_user_app_list"
const val ENABLE_LOAD_SYSTEM_APP_LIST = "enable_load_system_app_list"

const val SP_DUPLICATE_MESSAGES_LIMITS = "duplicate_messages_limits"
const val SP_SILENT_PERIOD_START = "silent_period_start"
const val SP_SILENT_PERIOD_END = "silent_period_end"
const val SP_ENABLE_SILENT_PERIOD_LOGS = "enable_silent_period_logs"

const val SP_ENABLE_EXCLUDE_FROM_RECENTS = "enable_exclude_from_recents"
const val SP_ENABLE_PLAY_SILENCE_MUSIC = "enable_play_silence_music"
const val SP_ENABLE_ONE_PIXEL_ACTIVITY = "enable_one_pixel_activity"

const val SP_REQUEST_RETRY_TIMES = "request_retry_times"
const val SP_REQUEST_DELAY_TIME = "request_delay_time"
const val SP_REQUEST_TIMEOUT = "request_timeout"

const val SP_NOTIFY_CONTENT = "notify_content"
const val SP_EXTRA_DEVICE_MARK = "extra_device_mark"
const val SP_SUBID_SIM1 = "subid_sim1"
const val SP_SUBID_SIM2 = "subid_sim2"
const val SP_EXTRA_SIM1 = "extra_sim1"
const val SP_EXTRA_SIM2 = "extra_sim2"
const val SP_ENABLE_SMS_TEMPLATE = "enable_sms_template"
const val SP_SMS_TEMPLATE = "sms_template"

const val SP_PURE_CLIENT_MODE = "enable_pure_client_mode"
const val SP_PURE_TASK_MODE = "enable_pure_task_mode"
const val SP_DEBUG_MODE = "enable_debug_mode"

//const val SP_IS_FLOW_SYSTEM_LANGUAGE = "is_flow_system_language"
const val SP_LOCATION = "enable_location"
const val SP_LOCATION_ACCURACY = "location_accuracy"
const val SP_LOCATION_POWER_REQUIREMENT = "location_power_requirement"
const val SP_LOCATION_MIN_INTERVAL = "location_min_interval_time"
const val SP_LOCATION_MIN_DISTANCE = "location_min_distance"

const val SP_ENABLE_CACTUS = "enable_cactus"
const val CACTUS_TIMER = "cactus_timer"
const val CACTUS_LAST_TIMER = "cactus_last_timer"
const val CACTUS_DATE = "cactus_date"
const val CACTUS_END_DATE = "cactus_end_date"

//规则相关
const val STATUS_ON = 1
const val STATUS_OFF = 0
const val FILED_TRANSPOND_ALL = "transpond_all"
const val FILED_PHONE_NUM = "phone_num"
const val FILED_CALL_TYPE = "call_type"
const val FILED_PACKAGE_NAME = "package_name"
const val FILED_UID = "uid"
const val FILED_MSG_CONTENT = "msg_content"
const val FILED_INFORM_CONTENT = "inform_content"
const val FILED_MULTI_MATCH = "multi_match"
const val CHECK_IS = "is"
const val CHECK_CONTAIN = "contain"
const val CHECK_NOT_CONTAIN = "notcontain"
const val CHECK_START_WITH = "startwith"
const val CHECK_END_WITH = "endwith"
const val CHECK_NOT_IS = "notis"
const val CHECK_REGEX = "regex"
const val CHECK_SIM_SLOT_ALL = "ALL"
const val CHECK_SIM_SLOT_1 = "SIM1"
const val CHECK_SIM_SLOT_2 = "SIM2"

//发送通道执行逻辑：ALL=全部执行, UntilFail=失败即终止, UntilSuccess=成功即终止
const val SENDER_LOGIC_ALL = "ALL"
const val SENDER_LOGIC_UNTIL_FAIL = "UntilFail"
const val SENDER_LOGIC_UNTIL_SUCCESS = "UntilSuccess"
const val SENDER_LOGIC_RETRY = "Retry"

//发送通道
const val TYPE_DINGTALK_GROUP_ROBOT = 0
const val TYPE_EMAIL = 1
const val TYPE_BARK = 2
const val TYPE_WEBHOOK = 3
const val TYPE_WEWORK_ROBOT = 4
const val TYPE_WEWORK_AGENT = 5
const val TYPE_SERVERCHAN = 6
const val TYPE_TELEGRAM = 7
const val TYPE_SMS = 8
const val TYPE_FEISHU = 9
const val TYPE_PUSHPLUS = 10
const val TYPE_GOTIFY = 11
const val TYPE_DINGTALK_INNER_ROBOT = 12
const val TYPE_FEISHU_APP = 13
const val TYPE_URL_SCHEME = 14
const val TYPE_SOCKET = 15

//前台服务
const val FRONT_NOTIFY_ID = 0x1010
const val FRONT_CHANNEL_ID = "com.idormy.sms.forwarder"
const val FRONT_CHANNEL_NAME = "SmsForwarder Foreground Service"

//声音警报
const val EVENT_ALARM_ACTION = "EVENT_ALARM_ACTION"

//吐司监听
const val EVENT_TOAST_SUCCESS = "key_toast_success"
const val EVENT_TOAST_ERROR = "key_toast_error"
const val EVENT_TOAST_INFO = "key_toast_info"
const val EVENT_TOAST_WARNING = "key_toast_warning"

const val KEY_SENDER_ID = "key_sender_id"
const val KEY_SENDER_TYPE = "key_sender_type"
const val KEY_SENDER_CLONE = "key_sender_clone"
const val KEY_SENDER_TEST = "key_sender_test"

const val KEY_RULE_ID = "key_rule_id"
const val KEY_RULE_TYPE = "key_rule_type"
const val KEY_RULE_CLONE = "key_rule_clone"

const val KEY_TASK_ID = "key_task_id"
const val KEY_TASK_TYPE = "key_task_type"
const val KEY_TASK_CLONE = "key_task_clone"

const val EVENT_LOAD_APP_LIST = "EVENT_LOAD_APP_LIST"

const val EVENT_KEY_SIM_SLOT = "EVENT_KEY_SIM_SLOT"
const val EVENT_KEY_PHONE_NUMBERS = "EVENT_KEY_PHONE_NUMBERS"

//在线升级URL
const val KEY_UPDATE_URL = "https://xupdate.ppps.cn/update/checkVersion"

//HttpServer相关
const val HTTP_SERVER_PORT = 5000
const val HTTP_SERVER_TIME_OUT = 10
const val HTTP_SUCCESS_CODE: Int = 200
const val HTTP_FAILURE_CODE: Int = 500
const val SP_ENABLE_SERVER_AUTORUN = "enable_server_autorun"
const val SP_SERVER_SAFETY_MEASURES = "server_safety_measures"
const val SP_SERVER_SIGN_KEY = "server_sign_key"
const val SP_SERVER_TIME_TOLERANCE = "server_time_tolerance"
const val SP_SERVER_PUBLIC_KEY = "server_public_key"
const val SP_SERVER_PRIVATE_KEY = "server_private_key"
const val SP_SERVER_WEB_PATH = "server_web_path"
const val SP_ENABLE_API_CLONE = "enable_api_clone"
const val SP_ENABLE_API_SMS_SEND = "enable_api_sms_send"
const val SP_ENABLE_API_SMS_QUERY = "enable_api_sms_query"
const val SP_ENABLE_API_CALL_QUERY = "enable_api_call_query"
const val SP_ENABLE_API_CONTACT_QUERY = "enable_api_contact_query"
const val SP_ENABLE_API_CONTACT_ADD = "enable_api_contact_add"
const val SP_ENABLE_API_BATTERY_QUERY = "enable_api_battery_query"
const val SP_ENABLE_API_WOL = "enable_api_wol"
const val SP_ENABLE_API_LOCATION = "enable_api_location"
const val SP_API_LOCATION_CACHE = "api_location_cache"
const val SP_WOL_HISTORY = "wol_history"
const val SP_SERVER_ADDRESS = "server_address"
const val SP_SERVER_HISTORY = "server_history"
const val SP_SERVER_CONFIG = "server_config"
const val SP_CLIENT_SAFETY_MEASURES = "client_safety_measures"
const val SP_CLIENT_SIGN_KEY = "client_sign_key"


//自动任务
const val MAX_SETTING_NUM = 5 //最大条件/动作设置条数
const val KEY_TEST_CONDITION = "key_test_condition"
const val KEY_EVENT_DATA_CONDITION = "event_data_condition"
const val KEY_BACK_CODE_CONDITION = 1000
const val KEY_BACK_DATA_CONDITION = "back_data_condition"
const val KEY_BACK_DESCRIPTION_CONDITION = "back_description_condition"

const val KEY_EVENT_DATA_ACTION = "event_data_action"
const val KEY_BACK_CODE_ACTION = 2000
const val KEY_BACK_DATA_ACTION = "back_data_action"
const val KEY_BACK_DESCRIPTION_ACTION = "back_description_action"

//注意：TASK_CONDITION_XXX 枚举值 等于 TASK_CONDITION_FRAGMENT_LIST 索引加上 KEY_BACK_CODE_CONDITION，不可改变
const val TASK_CONDITION_CRON = 1000
const val TASK_CONDITION_TO_ADDRESS = 1001
const val TASK_CONDITION_LEAVE_ADDRESS = 1002
const val TASK_CONDITION_NETWORK = 1003
const val TASK_CONDITION_SIM = 1004
const val TASK_CONDITION_BATTERY = 1005
const val TASK_CONDITION_CHARGE = 1006
const val TASK_CONDITION_LOCK_SCREEN = 1007

//注意：TASK_ACTION_XXX 枚举值 等于 TASK_ACTION_FRAGMENT_LIST 索引加上 KEY_BACK_CODE_ACTION，不可改变
const val TASK_ACTION_SENDSMS = 2000
const val TASK_ACTION_NOTIFICATION = 2001
const val TASK_ACTION_CLEANER = 2002
const val TASK_ACTION_SETTINGS = 2003
const val TASK_ACTION_HTTPSERVER = 2005
const val TASK_ACTION_RULE = 2006
const val TASK_ACTION_SENDER = 2007
const val TASK_ACTION_ALARM = 2008
const val TASK_ACTION_RESEND = 2009
const val TASK_ACTION_TASK = 2010

const val SP_BATTERY_INFO = "battery_info"
const val SP_BATTERY_STATUS = "battery_status"
const val SP_BATTERY_LEVEL = "battery_level"
const val SP_BATTERY_PCT = "battery_pct"
const val SP_BATTERY_PLUGGED = "battery_plugged"

const val SP_NETWORK_STATE = "network_state"
const val SP_DATA_SIM_SLOT = "data_sim_slot"
const val SP_WIFI_SSID = "wifi_ssid"
const val SP_IPV4 = "ipv4"
const val SP_IPV6 = "ipv6"
const val SP_SIM_STATE = "sim_state"
const val SP_LOCATION_INFO_OLD = "location_info_old"
const val SP_LOCATION_INFO_NEW = "location_info_new"
const val SP_LOCK_SCREEN_ACTION = "lock_screen_action"

//SIM卡已准备就绪时，延迟5秒（给够搜索信号时间）才执行任务
const val DELAY_TIME_AFTER_SIM_READY = 5000L

//切换语言需要替换的自定义模板标签列表
//val TAG_LANG = arrayOf("zh_CN", "zh_TW", "en")
val TAG_LIST = arrayOf(
    mapOf("zh_CN" to "{{来源号码}}", "zh_TW" to "{{來源號碼}}", "en" to "{{FROM}}"),
    mapOf("zh_CN" to "{{短信内容}}", "zh_TW" to "{{簡訊內容}}", "en" to "{{SMS}}"),
    mapOf("zh_CN" to "{{APP包名}}", "zh_TW" to "{{APP包名}}", "en" to "{{PACKAGE_NAME}}"),
    mapOf("zh_CN" to "{{APP名称}}", "zh_TW" to "{{APP名稱}}", "en" to "{{APP_NAME}}"),
    mapOf("zh_CN" to "{{通知内容}}", "zh_TW" to "{{通知內容}}", "en" to "{{MSG}}"),
    mapOf("zh_CN" to "{{卡槽信息}}", "zh_TW" to "{{卡槽信息}}", "en" to "{{CARD_SLOT}}"),
    mapOf("zh_CN" to "{{卡槽主键}}", "zh_TW" to "{{卡槽主鍵}}", "en" to "{{CARD_SUBID}}"),
    mapOf("zh_CN" to "{{接收时间}}", "zh_TW" to "{{接收時間}}", "en" to "{{RECEIVE_TIME}}"),
    mapOf("zh_CN" to "{{当前时间}}", "zh_TW" to "{{當前時間}}", "en" to "{{CURRENT_TIME}}"),
    mapOf("zh_CN" to "{{设备名称}}", "zh_TW" to "{{設備名稱}}", "en" to "{{DEVICE_NAME}}"),
    mapOf(
        "zh_CN" to "{{当前应用版本号}}",
        "zh_TW" to "{{當前應用版本號}}",
        "en" to "{{APP_VERSION}}"
    ),
    mapOf("zh_CN" to "{{通知标题}}", "zh_TW" to "{{通知標題}}", "en" to "{{TITLE}}"),
    mapOf("zh_CN" to "{{通知Scheme}}", "zh_TW" to "{{通知Scheme}}", "en" to "{{SCHEME}}"),
    mapOf("zh_CN" to "{{通话类型}}", "zh_TW" to "{{通話類型}}", "en" to "{{CALL_TYPE}}"),
    mapOf("zh_CN" to "{{定位信息}}", "zh_TW" to "{{定位信息}}", "en" to "{{LOCATION}}"),
    mapOf(
        "zh_CN" to "{{定位信息_经度}}",
        "zh_TW" to "{{定位信息_經度}}",
        "en" to "{{LOCATION_LONGITUDE}}"
    ),
    mapOf(
        "zh_CN" to "{{定位信息_纬度}}",
        "zh_TW" to "{{定位信息_緯度}}",
        "en" to "{{LOCATION_LATITUDE}}"
    ),
    mapOf(
        "zh_CN" to "{{定位信息_地址}}",
        "zh_TW" to "{{定位信息_地址}}",
        "en" to "{{LOCATION_ADDRESS}}"
    ),
    mapOf("zh_CN" to "{{电池电量}}", "zh_TW" to "{{電池電量}}", "en" to "{{BATTERY_PCT}}"),
    mapOf("zh_CN" to "{{电池状态}}", "zh_TW" to "{{電池狀態}}", "en" to "{{BATTERY_STATUS}}"),
    mapOf("zh_CN" to "{{充电方式}}", "zh_TW" to "{{充電方式}}", "en" to "{{BATTERY_PLUGGED}}"),
    mapOf("zh_CN" to "{{电池信息}}", "zh_TW" to "{{電池信息}}", "en" to "{{BATTERY_INFO}}")
)
