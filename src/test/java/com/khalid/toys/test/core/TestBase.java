package com.khalid.toys.test.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.khalid.toys.core.Application;
import com.khalid.toys.core.domain.User;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;

/**
 * Created by 费玥 on 2016/12/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public abstract class TestBase {

    protected User user;

    @Before
    public void setUp() throws JsonProcessingException {
        user = new User();
        user.setLoginName("feiyue");
        user.setCredence(new char[]{'f','e','i','y','u','e'});
        user.setBirthday(new Date());
        user.setEmail("916073811@qq.com");
        user.setMobile("+8617701085294");
        user.setRegTime(new Date());
    }
}
