package com.khalid.toys.core.utils;

/**
 * Created by 费玥 on 2016/12/13.
 */
public enum CacheNamespaceEnum {
    ROLE_NAME_SPACE("ts:role:"),USER_LOGINNAME_SPACE("ts:user:loginName:"),
    USER_MOBILE_SPACE("ts:user:mobile:"),USER_NAME_SPACE("ts:user:");

    public final String keyNamespace;

    CacheNamespaceEnum(String keyNamespace){
        this.keyNamespace = keyNamespace;
    }

    public String getKeyNamespace(){
        return keyNamespace;
    }

    @Override
    public String toString(){
        return keyNamespace;
    }

}
