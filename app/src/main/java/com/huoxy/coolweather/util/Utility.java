package com.huoxy.coolweather.util;

import android.text.TextUtils;
import android.util.Log;

import com.huoxy.coolweather.db.City;
import com.huoxy.coolweather.db.County;
import com.huoxy.coolweather.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * Created by huoxy on 2017/5/7.
 *  解析Json数据
 */
public class Utility {
    private static final String TAG = "Utility";

    /**
     * 解析省数据响应
     * @param response 请求省数据接口返回的响应
     * @return 解析是否成功
     */
    public static boolean handleProvinceResponse(String response){
        if(!TextUtils.isEmpty(response)){
            try {
                Log.i(TAG, "handleProvinceResponse() - response = " + response);
                JSONArray provinces = new JSONArray(response);
                for(int i = 0; i < provinces.length(); i++){
                    JSONObject provinceObject = provinces.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 解析城市数据响应
     * @param response 请求城市数据接口返回的响应
     * @param provinceId 所属省ID
     * @return 解析是否成功
     */
    public static boolean handleCityResponse(String response, int provinceId){
        if(!TextUtils.isEmpty(response)){
            try {
                Log.i(TAG, "handleCityResponse() -  provinceId = " + provinceId +", response = " + response);
                JSONArray cities = new JSONArray(response);
                for(int i = 0; i < cities.length(); i++){
                    JSONObject cityObject = cities.getJSONObject(i);
                    City city = new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }


    /**
     * 解析县数据响应
     * @param response 请求县数据接口返回的响应
     * @param cityId 所属城市Id
     * @return 解析是否成功
     */
    public static boolean handleCountyResponse(String response, int cityId){
        if(!TextUtils.isEmpty(response)){
            try {
                Log.i(TAG, "handleCountyResponse() - cityId = " + cityId + ", response = " + response);
                JSONArray counties = new JSONArray(response);
                for(int i = 0; i < counties.length(); i++){
                    JSONObject countyObject = counties.getJSONObject(i);
                    County county = new County();
                    county.setCountyName(countyObject.getString("name"));
                    county.setWeatherId(countyObject.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
