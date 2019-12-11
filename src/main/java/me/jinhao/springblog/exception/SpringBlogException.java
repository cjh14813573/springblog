package me.jinhao.springblog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SpringBlogException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private Integer errorCode;

    public Integer getCode(){
        return this.errorCode;
    }

    public SpringBlogException(){

    }

    public SpringBlogException(String message){
        super(message);
    }

    public SpringBlogException(Integer errorCode, String message){
        super(message);
        this.errorCode = errorCode;
    }

    public SpringBlogException(String message, Throwable cause){
        super(message, cause);
    }
}