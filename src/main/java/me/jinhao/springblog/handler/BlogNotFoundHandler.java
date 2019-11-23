package me.jinhao.springblog.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import me.jinhao.springblog.exception.BlogNotFoundException;

@ControllerAdvice
public class BlogNotFoundHandler {

    @ExceptionHandler(BlogNotFoundException.class)
    public String notFoundHandler(Exception e){
        return "/error/404";
    }

}