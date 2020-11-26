package com.my.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @ClassName GlobalException
 * @Description TODO
 * @Author wang
 * @Date 2020/9/21 16:37
 * @Version 1.0
 **/
@ControllerAdvice
@ResponseBody
public class GlobalException {
    private static final Logger logger= LoggerFactory.getLogger(GlobalException.class);
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public JsonResult handleHttpMessageNotReadableException(MissingServletRequestParameterException ex){
        logger.error(ex.getMessage());
        return new JsonResult("400","缺少必要的请求参数");
    }
    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public JsonResult handleNullExceptio(NullPointerException ex){
            logger.error(ex.getMessage());
            return new JsonResult("500","空指针异常");
    }
    //一劳永逸的写法
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public JsonResult handlerException(Exception ex){
        logger.error(ex.getMessage());
        return new JsonResult("500","系统异常");
    }
    @ExceptionHandler(CustomException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public JsonResult handlerCustomException(CustomException ex){
        logger.error(ex.getMsg());
        return new JsonResult(ex.getCode(),ex.getMsg());
    }
}
