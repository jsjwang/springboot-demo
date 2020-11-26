package com.my.exception;

import java.io.Serializable;

/**
 * @ClassName CustomException
 * @Description TODO
 * @Author wang
 * @Date 2020/9/21 17:00
 * @Version 1.0
 **/
public class CustomException extends Exception implements Serializable {
    private String code;
    private String msg;
    public CustomException(CustomExceptionMsgEnum customExceptionMsgEnum){
        this.code=customExceptionMsgEnum.getCode();
        this.msg=customExceptionMsgEnum.getMsg();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
