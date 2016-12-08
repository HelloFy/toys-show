package com.khalid.toys.test.core.service;

import com.khalid.toys.core.Application;
import com.khalid.toys.core.service.UserService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by 费玥 on 2016/12/8.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class ServiceTestBase {

    @Autowired
    protected UserService userService;
}
