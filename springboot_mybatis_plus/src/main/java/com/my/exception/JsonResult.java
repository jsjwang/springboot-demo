package com.my.exception;

/**
 * @ClassName JsonResult
 * @Description TODO
 * @Author wang
 * @Date 2020/9/21 16:33
 * @Version 1.0
 **/
public class JsonResult<T> {
    private String code;
    private String msg;
    private T data;

    public JsonResult(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public JsonResult(T data){
        this.code="200";
        this.msg="操作成功";
        this.data=data;
    }
    public JsonResult(String msg,T data){
        this.code="200";
        this.msg=msg;
        this.data=data;
    }
    public  JsonResult(){
        this.code="200";
        this.msg="操作成功";
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
