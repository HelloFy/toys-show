package com.khalid.toys.core.web;

import com.khalid.toys.core.domain.User;
import com.khalid.toys.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 费玥 on 2016/12/7.
 */

@RestController
public class IndexController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/","/index"})
    public ModelAndView index(Map<String, Object> model){
        return new ModelAndView("index");
    }

    @RequestMapping(value="/login.html")
    public ModelAndView login(Map<String, Object> model){
        return new ModelAndView("login/login");
    }

    @RequestMapping(value = "/register")
    public Map<String,String> register(User user){
        Map<String,String> resultMap = new HashMap<>();
        userService.regIn(user);
        return resultMap;
    }
}
