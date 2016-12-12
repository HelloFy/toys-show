package com.khalid.toys.core.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by 费玥 on 2016/12/12.
 */
@Service
public class SystemService {

    private final static int STRENGTH =10;

    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(STRENGTH);

    public static char[] encodePassWord(char[] rawPassWord){
        return bCryptPasswordEncoder.encode(new String(rawPassWord)).toCharArray();
    }
}
