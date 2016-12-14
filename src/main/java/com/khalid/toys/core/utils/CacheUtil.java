package com.khalid.toys.core.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by 费玥 on 2016/12/10.
 */
@Component
public class CacheUtil {

    private static StringRedisTemplate stringRedisTemplate;

    public static void put(String key , String value){
        stringRedisTemplate.opsForValue().set(key,value);
    }

    public static void put(String key , String value , long expireTime){
        put(key,value);
        stringRedisTemplate.expire(key,expireTime, TimeUnit.SECONDS);
    }

    public static void hPut(String hKey , String field , String value){
        stringRedisTemplate.opsForHash().put(hKey,field,value);
    }

    public static String get(String key){
        return stringRedisTemplate.opsForValue().get(key);
    }

    public static String hGet(String hKey , String field){
        return (String) stringRedisTemplate.opsForHash().get(hKey,field);
    }

    public static Set<Object> hAllField(String hKey){
        return  stringRedisTemplate.opsForHash().keys(hKey);
    }

    public static <V> V getObject(String key,Class<V> clazz){
        return FastJsonUtil.string2obj(get(key),clazz);
    }

    public static <V> V hGetObject(String hKey , String field ,Class<V> clazz){
        return FastJsonUtil.string2obj(hGet(hKey, field),clazz);
    }

    public static <V> void putObject(String key , V obj){
        put(key,FastJsonUtil.obj2string(obj));
    }

    public static <V> void hPutObject(String hKey, String field, V obj){
        hPut(hKey,field,FastJsonUtil.obj2string(obj));
    }

    public static void rmKey(String key){
        stringRedisTemplate.delete(key);
    }

    public static void rmHKeys(String hKey , String... field){
        stringRedisTemplate.opsForHash().delete(hKey,field);
    }

    public static boolean hasKey(String key){
        return stringRedisTemplate.hasKey(key);
    }

    public static boolean hasHkey(String hKey ,String field){
        return stringRedisTemplate.opsForHash().hasKey(hKey,field);
    }

    @Autowired
    public void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate){
        if (CacheUtil.stringRedisTemplate == null){
            CacheUtil.stringRedisTemplate = stringRedisTemplate;
        }
    }
}
