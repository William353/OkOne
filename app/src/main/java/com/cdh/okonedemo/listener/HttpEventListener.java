package com.cdh.okonedemo.listener;


import android.util.Log;

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
 * Created by wangpeng on 12/13/21
 */
public class HttpEventListener extends EventListener {
    private static final String TAG = "GlobalEventListener";


    @Override
    public void callEnd(@NotNull Call call) {
        Log.d(TAG, "callEnd: call = [" + call + "]");
    }

    @Override
    public void callFailed(@NotNull Call call, @NotNull IOException ioe) {
        Log.d(TAG, "callFailed: call = [" + call + "], ioe = [" + ioe + "]");
    }

    @Override
    public void callStart(@NotNull Call call) {
        Log.d(TAG, "callStart: call = [" + call + "]");
    }


    @Override
    public void connectEnd(@NotNull Call call, @NotNull InetSocketAddress inetSocketAddress, @NotNull Proxy proxy, @Nullable Protocol protocol) {
        Log.d(TAG, "connectEnd: call = [" + call + "], inetSocketAddress = [" + inetSocketAddress + "], proxy = [" + proxy + "], protocol = [" + protocol + "]");
    }

    @Override
    public void connectFailed(@NotNull Call call, @NotNull InetSocketAddress inetSocketAddress, @NotNull Proxy proxy, @Nullable Protocol protocol, @NotNull IOException ioe) {
        Log.d(TAG, "connectFailed: call = [" + call + "], inetSocketAddress = [" + inetSocketAddress + "], proxy = [" + proxy + "], protocol = [" + protocol + "], ioe = [" + ioe + "]");
    }

    @Override
    public void connectStart(@NotNull Call call, @NotNull InetSocketAddress inetSocketAddress, @NotNull Proxy proxy) {
        Log.d(TAG, "connectStart: call = [" + call + "], inetSocketAddress = [" + inetSocketAddress + "], proxy = [" + proxy + "]");
    }

    @Override
    public void connectionAcquired(@NotNull Call call, @NotNull Connection connection) {
        Log.d(TAG, "connectionAcquired: call = [" + call + "], connection = [" + connection + "]");
    }

    @Override
    public void connectionReleased(@NotNull Call call, @NotNull Connection connection) {
        Log.d(TAG, "connectionReleased: call = [" + call + "], connection = [" + connection + "]");
    }

    @Override
    public void dnsEnd(@NotNull Call call, @NotNull String domainName, @NotNull List<InetAddress> inetAddressList) {
        Log.d(TAG, "dnsEnd: call = [" + call + "], domainName = [" + domainName + "], inetAddressList = [" + inetAddressList + "]");
    }

    @Override
    public void dnsStart(@NotNull Call call, @NotNull String domainName) {
        Log.d(TAG, "dnsStart: call = [" + call + "], domainName = [" + domainName + "]");
    }

    @Override
    public void requestBodyEnd(@NotNull Call call, long byteCount) {
        Log.d(TAG, "requestBodyEnd: call = [" + call + "], byteCount = [" + byteCount + "]");
    }

    @Override
    public void requestBodyStart(@NotNull Call call) {
        Log.d(TAG, "requestBodyStart: call = [" + call + "]");
    }


    @Override
    public void requestHeadersEnd(@NotNull Call call, @NotNull Request request) {
        Log.d(TAG, "requestHeadersEnd: call = [" + call + "], request = [" + request + "]");
    }

    @Override
    public void requestHeadersStart(@NotNull Call call) {
        Log.d(TAG, "requestHeadersStart: call = [" + call + "]");
    }

    @Override
    public void responseBodyEnd(@NotNull Call call, long byteCount) {
        Log.d(TAG, "responseBodyEnd: call = [" + call + "], byteCount = [" + byteCount + "]");
    }

    @Override
    public void responseBodyStart(@NotNull Call call) {
        Log.d(TAG, "responseBodyStart: call = [" + call + "]");
    }


    @Override
    public void responseHeadersEnd(@NotNull Call call, @NotNull Response response) {
        Log.d(TAG, "responseHeadersEnd: call = [" + call + "], response = [" + response + "]");
    }

    @Override
    public void responseHeadersStart(@NotNull Call call) {
        Log.d(TAG, "responseHeadersStart: call = [" + call + "]");
    }

    @Override
    public void secureConnectEnd(@NotNull Call call, @Nullable Handshake handshake) {
        Log.d(TAG, "secureConnectEnd: call = [" + call + "], handshake = [" + handshake + "]");
    }

    @Override
    public void secureConnectStart(@NotNull Call call) {
        Log.d(TAG, "secureConnectStart: call = [" + call + "]");
    }
}
