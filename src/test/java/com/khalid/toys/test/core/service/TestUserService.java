package com.khalid.toys.test.core.service;

import com.khalid.toys.core.domain.User;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * Created by 费玥 on 2016/12/8.
 */
public class TestUserService extends ServiceTestBase {

    private User user;

    @Before
    public void setUp(){
        user = new User();
        user.setLoginName("feiyue");
        user.setCredence(new char[]{'f','e','i','y','u','e'});
        user.setBirthday(new Date());
        user.setEmail("916073811@qq.com");
        user.setMobile("+8617701085294");
        user.setRegTime(new Date());
    }

    @Test
    public void testReg(){
        userService.regIn(user);
    }

}
