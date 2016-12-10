package com.khalid.toys.test.core.service;

import com.khalid.toys.core.domain.User;
import com.khalid.toys.core.service.UserService;
import com.khalid.toys.test.core.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

/**
 * Created by 费玥 on 2016/12/8.
 */

public class TestUserService extends TestBase {

    @Autowired
    private UserService userService;

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
