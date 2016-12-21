package com.khalid.toys.core.configure.handler;

import com.khalid.toys.core.domain.Message;
import com.khalid.toys.core.utils.FastJsonUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 费玥 on 2016/12/15.
 */
public class CustomAuthSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        Message message = new Message();
        message.setResult(Message.MessageResult.SUCCESS);
        message.setErrorMsg("");
        httpServletResponse.getWriter().write(FastJsonUtil.obj2string(message));
    }
}
