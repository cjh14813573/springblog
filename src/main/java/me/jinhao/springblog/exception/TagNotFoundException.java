package me.jinhao.springblog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TagNotFoundException extends SpringBlogException{

    private static final long serialVersionUID = 1L;

    public TagNotFoundException(){

    }

    public TagNotFoundException(String message){
        super(message);
    }

    public TagNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}