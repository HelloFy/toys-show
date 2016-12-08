package com.khalid.toys.core.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by 费玥 on 2016/12/7.
 */

@Controller
public class IndexController {

    @RequestMapping(value = "/index")
    public String index(Map<String, Object> model){
        return "index";
    }
}
