package com.cdh.okonedemo

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.cdh.okone.OkOne
import com.cdh.okone.connection.callback.PreConnectCallback
import com.cdh.okonedemo.listener.HttpEventFactory
import com.cdh.okonedemo.http.GitHubService
import com.cdh.okonedemo.http.SearchData
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val BASE_URL = "https://api.github.com/"

    private val okHttpClient = OkHttpClient.Builder()
            .eventListenerFactory(HttpEventFactory())
            .addInterceptor(HttpLoggingInterceptor())
//            .connectionPool(ConnectionPool(1, 1, TimeUnit.SECONDS)) //测试用，设置连接的超时时间，1秒后连接会断开，再次发请求，会执行dns步骤
            .build()

    private val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        findViewById<View>(R.id.btn_build_client).setOnClickListener(this)
        findViewById<View>(R.id.btn_pre_connect_stackoverflow).setOnClickListener(this)
        findViewById<View>(R.id.btn_pre_connect_head).setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_build_client -> {
                testRequestServer()
            }
            R.id.btn_pre_connect_stackoverflow -> testPreBuildConnection(BASE_URL)
            R.id.btn_pre_connect_head -> testPreConnectionHead()
        }
    }

    /**
     * 测试预建连
     */
    private fun testPreBuildConnection(url: String) {
        Log.d(TAG, "开始预建连: $url")
        OkOne.preBuildConnection(okHttpClient, url, object : PreConnectCallback {
            override fun connectCompleted(url: String) {
                Log.d(TAG, "预建连成功: $url")
            }

            override fun connectFailed(t: Throwable) {
                Log.e(TAG, "预建连失败", t)
            }
        })
    }

    private fun testPreConnectionHead() {
        Log.d(TAG, "开始请求 预连接 -------")
        val service = retrofit.create(GitHubService::class.java)
        service.preConnect("william353")?.enqueue(object : retrofit2.Callback<Void> {

            override fun onResponse(call: retrofit2.Call<Void>?, response: retrofit2.Response<Void>?) {
                Log.d(TAG, "预连接 success :${response?.headers()}")
            }

            override fun onFailure(call: retrofit2.Call<Void>?, t: Throwable?) {
                Log.e(TAG, "预连接 fail ${t?.message}")
            }
        })
    }

    /**
     * 测试不同配方的接口请求
     */
    private fun testRequestServer() {
        Log.d(TAG, "开始请求")
        val service = retrofit.create(GitHubService::class.java)
        service.listRepos("william353")?.enqueue(object : retrofit2.Callback<SearchData?> {

            override fun onResponse(call: retrofit2.Call<SearchData?>?, response: retrofit2.Response<SearchData?>?) {
                Log.d(TAG, "requestRepo success totalCount:${response?.body()?.total_count}")
            }

            override fun onFailure(call: retrofit2.Call<SearchData?>?, t: Throwable?) {
                Log.e(TAG, "requestRepo fail ${t?.message}")
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