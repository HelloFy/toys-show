package com.khalid.toys.core.web;

import com.khalid.toys.core.domain.Message;
import com.qq.connect.QQConnectException;
import com.qq.connect.oauth.Oauth;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 费玥 on 2016/12/29.
 */
@RestController
public class OAuthLoginController {

    @ExceptionHandler({QQConnectException.class,IOException.class})
    public Message AuthExceptionHandler(){
        Message message = new Message();
        message.setErrorMsg("QQ登录失败，请稍候重试.");
        message.setResult(Message.MessageResult.FAIL);
        return message;
    }

    @RequestMapping(value = "/qqLogin",method = RequestMethod.GET)
    public void qqLogin(HttpServletRequest request,HttpServletResponse response) throws QQConnectException, IOException {
        response.sendRedirect(new Oauth().getAuthorizeURL(request));
    }
}
