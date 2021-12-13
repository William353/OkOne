package com.cdh.okonedemo.listener;

import org.jetbrains.annotations.NotNull;

import okhttp3.Call;
import okhttp3.EventListener;

/**
 * Created by wangpeng on 12/13/21
 */
public class HttpEventFactory implements EventListener.Factory {
    @NotNull
    @Override
    public EventListener create(@NotNull Call call) {
        return new HttpEventListener();
    }
}
