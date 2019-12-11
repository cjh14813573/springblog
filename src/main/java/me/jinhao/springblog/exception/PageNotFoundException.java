package me.jinhao.springblog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PageNotFoundException extends SpringBlogException{

    private static final long serialVersionUID = 1L;

    public PageNotFoundException(){

    }

    public PageNotFoundException(String message){
        super(message);
    }

    public PageNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}