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

    private MessageResult result;

    private Object message;

    private String errorMsg;

    public Message() {
    }

    public Object getResult() {
        return result;
    }

    public void setResult(MessageResult result) {
        this.result = result;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public static enum MessageResult{
        SUCCESS(true),FAIL(false);
        private boolean res ;
        MessageResult(boolean res){
            this.res = res;
        }
        @Override
        public String toString() {
            return Boolean.valueOf(res).toString();
        }
    }
}

