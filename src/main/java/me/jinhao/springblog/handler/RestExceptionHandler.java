package me.jinhao.springblog.handler;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import me.jinhao.springblog.exception.SpringBlogException;
import me.jinhao.springblog.util.CommonRest;

import org.springframework.web.bind.annotation.ExceptionHandler;


@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(Exception.class)
    public CommonRest notFoundHandler(SpringBlogException e){
        return new CommonRest(-1, e.getCode(), e.getMessage());
    }

}