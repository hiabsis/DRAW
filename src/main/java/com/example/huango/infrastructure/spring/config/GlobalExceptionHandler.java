package com.example.huango.infrastructure.spring.config;

import com.example.huango.infrastructure.spring.response.DateResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 拦截所有程序异常
     */
    @ExceptionHandler(value=Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public DateResponse<String> errorHandler(HttpServletRequest request, Exception ex){
        DateResponse<String> response = new DateResponse<>();
        response.setCode(ex.getMessage());
        response.setMessage(ex.getMessage());
        return response;
    }


}
