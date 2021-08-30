package com.takeaway.exceptionhandler;

import com.takeaway.exception.NotEnoughtException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class IndexExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = NotEnoughtException.class)
    public Map<String,Object> LoginExceptionHandler(Exception e){
        System.out.println(e.getMessage());
        Map<String,Object> map = new HashMap<>();
        map.put("message","登录/注册失败");
        return map;
    }
}
