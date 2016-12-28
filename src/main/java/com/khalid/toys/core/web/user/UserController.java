package com.khalid.toys.core.web.user;

import com.khalid.toys.core.domain.Message;
import com.khalid.toys.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 费玥 on 2016/12/10.
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private Message message;

    @RequestMapping(value = "existName2",method = RequestMethod.GET)
    public Message isExistName(String loginName) {
        if (userService.isExistLoginName(loginName))
            message.setResult(Message.MessageResult.FAIL);
        else
            message.setResult(Message.MessageResult.SUCCESS);
        message.setErrorMsg("");
        return message;
    }

    @RequestMapping(value = "existMobile",method = RequestMethod.GET)
    public Message isExistMobile(String mobile){
        if (userService.isExistMobile(mobile))
            message.setResult(Message.MessageResult.FAIL);
        else
            message.setResult(Message.MessageResult.SUCCESS);
        message.setErrorMsg("");
        return message;
    }

    @RequestMapping("isLogin")
    public Message isLogin(){
        return message;
    }
}
