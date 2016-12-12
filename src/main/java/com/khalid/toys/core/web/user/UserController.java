package com.khalid.toys.core.web.user;

import com.khalid.toys.core.domain.Message;
import com.khalid.toys.core.service.UserService;
import com.khalid.toys.core.utils.CacheUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("existName")
    public Message isExistName(String loginName) {
        if (!userService.isExistLoginName(loginName)){
            CacheUtil.put(loginName,"has",2);
            message.setResult(false);
        }
        else{
            message.setResult(true);}
        message.setErrorMsg("");
        return message;
    }

    @RequestMapping("existMobile")
    public Message isExistMobile(String mobile){
        if(!userService.isExistMobile(mobile)){
            CacheUtil.put(mobile,"has",2);
            message.setResult(false);
        }
        else{
            message.setResult(true);}
        message.setErrorMsg("");
        return message;
    }
}
