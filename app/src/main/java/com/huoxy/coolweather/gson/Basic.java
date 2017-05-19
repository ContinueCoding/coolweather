package com.huoxy.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by huoxy on 2017/5/19.
 *  天气实体的基本信息实体
 */
public class Basic {
    //对于JSON中不适合直接作为Java字段名的字段，通过此注解使之建立映射关系
    @SerializedName("city")
    public String cityName;

    @SerializedName("id")
    public String weatherId;

    public Update update;

    public class Update{
        @SerializedName("loc")
        public String updateTime;
    }
}
