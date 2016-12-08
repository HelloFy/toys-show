package com.khalid.toys.test.core.service;

import com.khalid.toys.core.domain.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;

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
    @Rollback
    public void testReg(){
        userService.regIn(user);
    }

    @Test
    public void testFindByEmail(){
        String email = "916073811@qq.com";
        User findUser = userService.findByEmail(email);
        Assert.assertTrue("错误，查询的用户不正确！",findUser.getLoginName().equals(user.getLoginName()));
    }

}
