package com.khalid.toys.core.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by 费玥 on 2016/12/10.
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@Component
public class CacheUtil {

    private static StringRedisTemplate stringRedisTemplate;

    public static void put(String key , String value){
        stringRedisTemplate.opsForValue().set(key,value);
    }

    public static String get(String key){
        return stringRedisTemplate.opsForValue().get(key);
    }

    public static <V> V getObject(String key,Class<V> clazz){
        return FastJsonUtil.string2obj(get(key),clazz);
    }

    public static <V> void putObject(String key , V obj){
        put(key,FastJsonUtil.obj2string(obj));
    }

    public static boolean hasKey(String key){
        return stringRedisTemplate.hasKey(key);
    }

    @Autowired
    public void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate){
        if (CacheUtil.stringRedisTemplate == null){
            CacheUtil.stringRedisTemplate = stringRedisTemplate;
        }
    }
}
