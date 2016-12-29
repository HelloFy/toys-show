package com.khalid.toys.core.web.user;

import com.khalid.toys.core.domain.Message;
import com.khalid.toys.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
/**
 * Created by 费玥 on 2016/12/10.
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "existName",method = RequestMethod.GET)
    public Message isExistName(String loginName) {
        Message message = new Message();
        if (userService.isExistLoginName(loginName))
            message.setResult(Message.MessageResult.FAIL);
        else
            message.setResult(Message.MessageResult.SUCCESS);
        message.setErrorMsg("");
        return message;
    }

    @RequestMapping(value = "existMobile",method = RequestMethod.GET)
    public Message isExistMobile(String mobile){
        Message message = new Message();
        if (userService.isExistMobile(mobile))
            message.setResult(Message.MessageResult.FAIL);
        else
            message.setResult(Message.MessageResult.SUCCESS);
        message.setErrorMsg("");
        return message;
    }

    @RequestMapping(value = "isLogin",method = RequestMethod.GET)
    public Message isLogin(HttpSession session){
        Message message = new Message();
        message.setResult(Message.MessageResult.FAIL);
        if(session.getAttribute("SPRING_SECURITY_CONTEXT")!=null){
            message.setResult(Message.MessageResult.SUCCESS);
        }
        return message;
    }
}
