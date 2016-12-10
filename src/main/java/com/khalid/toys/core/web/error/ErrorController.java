package com.khalid.toys.core.web.error;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 费玥 on 2016/12/10.
 */
@RestController
@RequestMapping("/error")
public class ErrorController {

    @RequestMapping("404.html")
    public ModelAndView NotFound(){
        return new ModelAndView("error/404");
    }
}
