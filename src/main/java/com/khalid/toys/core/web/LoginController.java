package com.khalid.toys.core.web;

import com.khalid.toys.core.domain.Message;
import com.khalid.toys.core.domain.User;
import com.khalid.toys.core.service.UserService;
import com.khalid.toys.core.utils.GenerateCaptchaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

/**
 * Created by 费玥 on 2016/12/29.
 */
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @ExceptionHandler({IllegalStateException.class, SQLException.class})
    public Message dupicateHandler(){
        Message message = new Message();
        message.setResult(Message.MessageResult.FAIL);
        message.setErrorMsg("登录名或手机号重复注册，请重新输入后注册。");
        return message;
    }

    @ExceptionHandler(Exception.class)
    public Message runExceptionHandler(){
        Message message = new Message();
        message.setResult(Message.MessageResult.FAIL);
        return message;
    }

    @RequestMapping(value="/login.html")
    public ModelAndView loginPage(Map<String, Object> model, HttpSession httpSession){
        return new ModelAndView("login/login");
    }

    @RequestMapping(value = "/register")
    public Message register(User user) throws SQLException {
        Message message = new Message();
        userService.regIn(user);
        message.setResult(Message.MessageResult.SUCCESS);
        message.setErrorMsg("");
        return message;
    }

    @RequestMapping(value = "/getCode",method = RequestMethod.GET)
    public void getCode(HttpSession session , HttpServletResponse response) throws IOException {
        GenerateCaptchaUtil captchaUtil = new GenerateCaptchaUtil(200,40,4,0);
        response.setContentType("image/jpeg");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        session.setAttribute("code",captchaUtil.getCode());
        captchaUtil.write(response.getOutputStream());
    }

    @RequestMapping(value = "/validateCode",method = RequestMethod.GET)
    public Message validateCode(HttpSession session,String validateCode){
        Message message = new Message();
        message.setErrorMsg("");
        message.setResult(Message.MessageResult.FAIL);
        if (session.getAttribute("code").toString().equalsIgnoreCase(validateCode)){
            message.setErrorMsg("");
            message.setResult(Message.MessageResult.SUCCESS);
        }
        return message;
    }
}
