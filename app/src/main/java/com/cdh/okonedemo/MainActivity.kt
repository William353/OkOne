package com.cdh.okonedemo

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.cdh.okone.OkOne
import com.cdh.okone.connection.callback.PreConnectCallback
import com.cdh.okonedemo.listener.HttpEventFactory
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import java.io.IOException
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        findViewById<View>(R.id.btn_build_client).setOnClickListener(this)
        findViewById<View>(R.id.btn_pre_connect_stackoverflow).setOnClickListener(this)
        findViewById<View>(R.id.btn_pre_connect_juejin).setOnClickListener(this)
        findViewById<View>(R.id.btn_pre_connect_zhihu).setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_build_client -> {
                testRequestServer(okHttpClient)
            }
            R.id.btn_pre_connect_stackoverflow -> testPreBuildConnection(okHttpClient, URL_FOR_TEST)
            R.id.btn_pre_connect_juejin -> testPreBuildConnection(okHttpClient, URL_JUEJIN)
            R.id.btn_pre_connect_zhihu -> testPreBuildConnection(okHttpClient, URL_ZHIHU)
        }
    }

    val okHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .eventListenerFactory(HttpEventFactory())
                .addInterceptor(HttpLoggingInterceptor())
                .build()
    }

    /**
     * 测试预建连
     */
    private fun testPreBuildConnection(client: OkHttpClient, url: String) {
        OkOne.preBuildConnection(client, url, object : PreConnectCallback {
            override fun connectCompleted(url: String) {
                Log.d(TAG, "预建连成功: $url")
            }

            override fun connectFailed(t: Throwable) {
                Log.e(TAG, "预建连失败", t)
            }
        })
    }

    /**
     * 测试不同配方的接口请求
     */
    private fun testRequestServer(client: OkHttpClient) {
        Log.d(TAG, "创建OkHttpClient: $client")
        val api = URL_FOR_TEST
        val request = Request.Builder()
                .url(api)
                .build()
        val call = client.newCall(request)
        call.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.d(TAG, "onFailure() called with: e = [$e]")
            }

            @Throws(IOException::class)
            override fun onResponse(call: Call, response: Response) {
                Log.d(TAG, "onResponse() called with: response = [$response]")
            }
        })
    }

    companion object {
        private const val TAG = "MainActivityTag"
        private const val URL_FOR_TEST = "https://stackoverflow.com/"
        private const val URL_JUEJIN = "https://juejin.cn/"
        private const val URL_ZHIHU = "https://www.zhihu.com/"
    }
}