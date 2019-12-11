package me.jinhao.springblog.util;

import lombok.Data;

//the common structure of response json
@Data
public class CommonRest {

    private Integer status = 1;

    private Integer errorCode = null;

    private String errorMsg = "";

    private Object responseBody;

    public CommonRest(Object response){
        this.responseBody = response;
    }

    public CommonRest(Integer status, Object response){
        this.status = status;
        this.responseBody = response;
    }

    public CommonRest(Integer status, Integer errorCode, String errorMsg){
        this.status = status;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public CommonRest(Integer status, Integer errorCode, String errorMsg, Object response){
        this.status = status;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.responseBody = response;
    }
    
}