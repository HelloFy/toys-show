package com.khalid.toys.core.web;

import com.khalid.toys.core.domain.Message;
import com.khalid.toys.core.domain.User;
import com.khalid.toys.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.Map;

/**
 * Created by 费玥 on 2016/12/7.
 */

@RestController
public class IndexController {

    @Autowired
    private UserService userService;

    @Autowired
    private Message message;

    @ExceptionHandler({IllegalStateException.class, SQLException.class})
    public Message dupicateHandler(){
        message.setResult("failed");
        message.setErrorMsg("登录名或手机号重复注册，请重新输入后注册。");
        return message;
    }

    @RequestMapping(value = {"/","/index"})
    public ModelAndView index(Map<String, Object> model){
        return new ModelAndView("index");
    }

    @RequestMapping(value="/login.html")
    public ModelAndView login(Map<String, Object> model,HttpSession httpSession){
        return new ModelAndView("login/login");
    }

    @RequestMapping(value = "/register")
    public Message register(User user) throws SQLException {
        userService.regIn(user);
        message.setResult("success");
        message.setErrorMsg("");
        return message;
    }
}
