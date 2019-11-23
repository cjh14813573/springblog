package me.jinhao.springblog.exception;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BlogNotFoundHandler {

    @ExceptionHandler(BlogNotFoundException.class)
    public String notFoundHandler(BlogNotFoundException e){
        return "/error/404";
    }

}