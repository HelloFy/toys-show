package com.khalid.toys.core.web;

import com.khalid.toys.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by 费玥 on 2016/12/7.
 */

@RestController
public class IndexController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/"},method = RequestMethod.GET)
    public ModelAndView index(Map<String, Object> model){
        return new ModelAndView("index");
    }
}
