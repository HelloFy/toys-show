package com.khalid.toys.core.utils;

import com.alibaba.fastjson.JSON;

/**
 * Created by 费玥 on 2016/12/10.
 */
public class FastJsonUtil {

    public static <V> String obj2string(V obj){
        return JSON.toJSONString(obj);
    }

    public static <V> V string2obj(String jsonStr,Class<V> clazz){
        return JSON.parseObject(jsonStr,clazz);
    }
}
