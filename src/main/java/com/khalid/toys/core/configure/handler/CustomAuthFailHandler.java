package com.khalid.toys.core.configure.handler;

import com.khalid.toys.core.domain.Message;
import com.khalid.toys.core.utils.FastJsonUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 费玥 on 2016/12/15.
 */
public class CustomAuthFailHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        Message message = new Message();
        message.setResult(Message.MessageResult.FAIL);
        message.setErrorMsg(e.toString());
        httpServletResponse.getWriter().write(FastJsonUtil.obj2string(message));
    }
}
