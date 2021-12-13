package com.cdh.okone

import com.cdh.okone.connection.BuildConnectionProcessor.buildConnection
import com.cdh.okone.connection.callback.PreConnectCallback
import com.cdh.okone.util.LogUtils.setEnableLog
import okhttp3.EventListener
import okhttp3.Interceptor
import okhttp3.OkHttpClient

/**
 * Created by chidehang on 2020/11/24
 */
object OkOne {
    /**
     * 是否启用全局统一OkHttpClient
     */
//    @JvmField
//    @Volatile
//    var useGlobalClient = true

    @JvmStatic
    fun setLogEnable(enable: Boolean) {
        setEnableLog(enable)
    }

    /**
     * 预建连
     */
    @JvmStatic
    fun preBuildConnection(client: OkHttpClient?, url: String?, callback: PreConnectCallback?) {
        buildConnection(client, url, callback)
    }


//    /**
//     * 设置全局EventListener
//     */
//    @JvmStatic
//    fun setGlobalEventListener(eventListener: EventListener?) {
//        MonitorRegistry.globalEventListener = eventListener
//    }
//
//    /**
//     * 添加全局Interceptor
//     */
//    @JvmStatic
//    fun addGlobalInterceptor(interceptor: Interceptor) {
//        MonitorRegistry.globalInterceptors.add(interceptor)
//    }
//
//    /**
//     * 添加全局Interceptor
//     */
//    @JvmStatic
//    fun addGlobalNetworkInterceptor(interceptor: Interceptor) {
//        MonitorRegistry.globalNetworkInterceptors.add(interceptor)
//    }
}