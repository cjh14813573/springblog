package me.jinhao.springblog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CategoryNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public CategoryNotFoundException(){

    }

    public CategoryNotFoundException(String message){
        super(message);
    }

    public CategoryNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}