package com.itoys.android.core

/**
 * @Author Gu Fanfan
 * @Email fanfan.worker@gmail.com
 * @Date 2024/4/3
 */
object CoreConfig {

    /** 页码key */
    var pageKey = "current"

    /** 分页数量key */
    var pageSizeKey = "size"

    /** 搜索关键字key */
    var searchKey = "keywords"

    /**
     * 搜索倒计时时间毫秒
     */
    var searchCountdownTimerFuture = 1500L

    /**
     * 默认api接口错误消息
     */
    var defaultApiErrorMsg = "请求接口出现异常, 请稍后重试"
}