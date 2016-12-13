package com.khalid.toys.test.core.service;

import com.khalid.toys.core.domain.User;
import com.khalid.toys.core.service.UserService;
import com.khalid.toys.test.core.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;

/**
 * Created by 费玥 on 2016/12/8.
 */

public class TestUserService extends TestBase {

    @Autowired
    private UserService userService;

    @Test
    public void testReg() throws SQLException {
        userService.regIn(user);
    }

    @Test
    public void testFindByEmail(){
        String email = "916073811@qq.com";
        User findUser = userService.findByEmail(email);
        Assert.assertTrue("错误，查询的用户不正确！",findUser.getLoginName().equals(user.getLoginName()));
    }

    @Test
    public void testFindByEmailOrMobile(){
        String eom = user.getEmail();
        User findUser = userService.findByEmailOrMobile(eom,eom);
        Assert.assertTrue("错误，查询的用户不正确！",findUser.getLoginName().equals(user.getLoginName()));
        eom = user.getMobile();
        findUser = userService.findByEmailOrMobile(eom,eom);
        Assert.assertTrue("错误，查询的用户不正确！",findUser.getLoginName().equals(user.getLoginName()));
    }

}
