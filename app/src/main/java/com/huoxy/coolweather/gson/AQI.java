package com.huoxy.coolweather.gson;

/**
 * Created by huoxy on 2017/5/19.
 */
public class AQI {

    public AQICity city;

    public class AQICity{
        public String aqi;
        public String pm25;
    }
}
