package com.khalid.toys.core.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by 费玥 on 2016/12/7.
 */

@RestController
public class IndexController {

    @RequestMapping(value = {"/","/index"})
    public ModelAndView index(Map<String, Object> model){
        return new ModelAndView("index");
    }

    @RequestMapping(value="/login.html")
    public ModelAndView login(Map<String, Object> model){
        return new ModelAndView("login/login");
    }
}
