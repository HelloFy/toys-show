package com.khalid.toys.core.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by 费玥 on 2016/12/12.
 */
@Component
@Scope("prototype")
public class Message implements Serializable {

    private static final long serialVersionUID = 8970813727914845893L;

    private Object result;

    private String errorMsg;

    public Message() {
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}

