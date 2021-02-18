package com.cdh.okonedemo;

import android.util.Log;

import com.cdh.okone.GlobalOkHttpClientManager;
import com.cdh.okone.OkOne;
import com.cdh.okone.monitor.MonitorRegistry;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;

import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by chidehang on 2021/2/18
 */
public class OkOneConfigur {

    public static void config() {
        OkOne.setLogEnable(true);
        OkOne.useGlobalClient = true;
        // 设置请求优先级功能
        OkOne.enableRequestPriority(true);
        // 设置全局EventListener
        OkOne.setGlobalEventListener(new EventListener() {

            private static final String TAG = "GlobalEventListener";

            @Override
            public void cacheConditionalHit(@NotNull Call call, @NotNull Response cachedResponse) {
                Log.d(TAG, "call = [" + call + "], cachedResponse = [" + cachedResponse + "]");
            }

            @Override
            public void cacheHit(@NotNull Call call, @NotNull Response response) {
                Log.d(TAG, "call = [" + call + "], response = [" + response + "]");
            }

            @Override
            public void cacheMiss(@NotNull Call call) {
                Log.d(TAG, "call = [" + call + "]");
            }

            @Override
            public void callEnd(@NotNull Call call) {
                Log.d(TAG, "call = [" + call + "]");
            }

            @Override
            public void callFailed(@NotNull Call call, @NotNull IOException ioe) {
                Log.d(TAG, "call = [" + call + "], ioe = [" + ioe + "]");
            }

            @Override
            public void callStart(@NotNull Call call) {
                Log.d(TAG, "call = [" + call + "]");
            }

            @Override
            public void canceled(@NotNull Call call) {
                Log.d(TAG, "call = [" + call + "]");
            }

            @Override
            public void connectEnd(@NotNull Call call, @NotNull InetSocketAddress inetSocketAddress, @NotNull Proxy proxy, @Nullable Protocol protocol) {
                Log.d(TAG, "call = [" + call + "], inetSocketAddress = [" + inetSocketAddress + "], proxy = [" + proxy + "], protocol = [" + protocol + "]");
            }

            @Override
            public void connectFailed(@NotNull Call call, @NotNull InetSocketAddress inetSocketAddress, @NotNull Proxy proxy, @Nullable Protocol protocol, @NotNull IOException ioe) {
                Log.d(TAG, "call = [" + call + "], inetSocketAddress = [" + inetSocketAddress + "], proxy = [" + proxy + "], protocol = [" + protocol + "], ioe = [" + ioe + "]");
            }

            @Override
            public void connectStart(@NotNull Call call, @NotNull InetSocketAddress inetSocketAddress, @NotNull Proxy proxy) {
                Log.d(TAG, "call = [" + call + "], inetSocketAddress = [" + inetSocketAddress + "], proxy = [" + proxy + "]");
            }

            @Override
            public void connectionAcquired(@NotNull Call call, @NotNull Connection connection) {
                Log.d(TAG, "call = [" + call + "], connection = [" + connection + "]");
            }

            @Override
            public void connectionReleased(@NotNull Call call, @NotNull Connection connection) {
                Log.d(TAG, "call = [" + call + "], connection = [" + connection + "]");
            }

            @Override
            public void dnsEnd(@NotNull Call call, @NotNull String domainName, @NotNull List<InetAddress> inetAddressList) {
                Log.d(TAG, "call = [" + call + "], domainName = [" + domainName + "], inetAddressList = [" + inetAddressList + "]");
            }

            @Override
            public void dnsStart(@NotNull Call call, @NotNull String domainName) {
                Log.d(TAG, "call = [" + call + "], domainName = [" + domainName + "]");
            }

            @Override
            public void proxySelectEnd(@NotNull Call call, @NotNull HttpUrl url, @NotNull List<Proxy> proxies) {
                Log.d(TAG, "call = [" + call + "], url = [" + url + "], proxies = [" + proxies + "]");
            }

            @Override
            public void proxySelectStart(@NotNull Call call, @NotNull HttpUrl url) {
                Log.d(TAG, "call = [" + call + "], url = [" + url + "]");
            }

            @Override
            public void requestBodyEnd(@NotNull Call call, long byteCount) {
                Log.d(TAG, "call = [" + call + "], byteCount = [" + byteCount + "]");
            }

            @Override
            public void requestBodyStart(@NotNull Call call) {
                Log.d(TAG, "call = [" + call + "]");
            }

            @Override
            public void requestFailed(@NotNull Call call, @NotNull IOException ioe) {
                Log.d(TAG, "call = [" + call + "], ioe = [" + ioe + "]");
            }

            @Override
            public void requestHeadersEnd(@NotNull Call call, @NotNull Request request) {
                Log.d(TAG, "call = [" + call + "], request = [" + request + "]");
            }

            @Override
            public void requestHeadersStart(@NotNull Call call) {
                Log.d(TAG, "call = [" + call + "]");
            }

            @Override
            public void responseBodyEnd(@NotNull Call call, long byteCount) {
                Log.d(TAG, "call = [" + call + "], byteCount = [" + byteCount + "]");
            }

            @Override
            public void responseBodyStart(@NotNull Call call) {
                Log.d(TAG, "call = [" + call + "]");
            }

            @Override
            public void responseFailed(@NotNull Call call, @NotNull IOException ioe) {
                Log.d(TAG, "call = [" + call + "], ioe = [" + ioe + "]");
            }

            @Override
            public void responseHeadersEnd(@NotNull Call call, @NotNull Response response) {
                Log.d(TAG, "call = [" + call + "], response = [" + response + "]");
            }

            @Override
            public void responseHeadersStart(@NotNull Call call) {
                Log.d(TAG, "call = [" + call + "]");
            }

            @Override
            public void satisfactionFailure(@NotNull Call call, @NotNull Response response) {
                Log.d(TAG, "call = [" + call + "], response = [" + response + "]");
            }

            @Override
            public void secureConnectEnd(@NotNull Call call, @Nullable Handshake handshake) {
                Log.d(TAG, "call = [" + call + "], handshake = [" + handshake + "]");
            }

            @Override
            public void secureConnectStart(@NotNull Call call) {
                Log.d(TAG, "call = [" + call + "]");
            }
        });
    }
}
