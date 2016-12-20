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

    @RequestMapping(value = "existName",method = RequestMethod.GET)
    public Message isExistName(String loginName) {
        message.setResult(userService.isExistLoginName(loginName));
        message.setErrorMsg("");
        return message;
    }

    @RequestMapping(value = "existMobile",method = RequestMethod.GET)
    public Message isExistMobile(String mobile){
        message.setResult(userService.isExistMobile(mobile));
        message.setErrorMsg("");
        return message;
    }

    @RequestMapping("isLogin")
    public Message isLogin(){
        return message;
    }
}
