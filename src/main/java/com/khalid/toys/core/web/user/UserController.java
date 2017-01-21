package com.khalid.toys.core.web.user;

import com.khalid.toys.core.domain.FollowRelation;
import com.khalid.toys.core.domain.Message;
import com.khalid.toys.core.domain.User;
import com.khalid.toys.core.service.UserService;
import com.khalid.toys.core.utils.FastJsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping(value = "isLoginAndGetInfo",method = RequestMethod.GET)
    public Message isLoginAndGetInfo(HttpSession session){
        Message message = new Message();
        message.setResult(Message.MessageResult.FAIL);
        SecurityContext securityContext = (SecurityContext) session.getAttribute("SPRING_SECURITY_CONTEXT");
        if(securityContext !=null && securityContext.getAuthentication().isAuthenticated()){
            User.CustomUserDetail userInfo = (User.CustomUserDetail) securityContext.getAuthentication().getPrincipal();
            message.setResult(Message.MessageResult.SUCCESS);
            message.setMessage(FastJsonUtil.obj2string(userInfo));
        }
        return message;
    }

    @RequestMapping(value = "{fansId}/follow/{id}",method = RequestMethod.PUT)
    public Message follow(@PathVariable String fansId , @PathVariable String id){
        Message message = new Message();
        FollowRelation relation = userService.follow(fansId,id);
        message.setResult(Message.MessageResult.SUCCESS);
        message.setMessage(relation.isMutual());
        return message;
    }
}
