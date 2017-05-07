package com.huoxy.coolweather.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by huoxy on 2017/5/7.
 *  网络请求类
 */
public class HttpUtil {

    /**
     * 请求数据
     * @param address 地址
     * @param callback 回调
     */
    public static void sendOkHttpRequest(String address, okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }
}
