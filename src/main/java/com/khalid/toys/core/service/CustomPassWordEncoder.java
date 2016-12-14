package com.khalid.toys.core.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Created by 费玥 on 2016/12/12.
 */
@Component
public class CustomPassWordEncoder implements PasswordEncoder {

    private final static int STRENGTH =10;

    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(STRENGTH);

    @Override
    public String encode(CharSequence charSequence) {
        return bCryptPasswordEncoder.encode(charSequence);
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return bCryptPasswordEncoder.matches(charSequence,s);
    }
}
