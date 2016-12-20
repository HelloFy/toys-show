package com.khalid.toys.core.web;

import com.khalid.toys.core.domain.Message;
import com.khalid.toys.core.domain.User;
import com.khalid.toys.core.service.UserService;
import com.khalid.toys.core.utils.GenerateCaptchaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

import static com.khalid.toys.core.utils.RoleNameConstant.COMMON_USER;

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

    @RequestMapping(value = {"/"})
    @PreAuthorize("hasPermission('', '"+COMMON_USER+"')")
    public ModelAndView index(Map<String, Object> model){
        return new ModelAndView("index");
    }

    @RequestMapping(value="/login.html")
    public ModelAndView loginPage(Map<String, Object> model,HttpSession httpSession){
        return new ModelAndView("login/login");
    }

    @RequestMapping(value = "/register")
    public Message register(User user) throws SQLException {
        userService.regIn(user);
        message.setResult("success");
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
}
