package me.jinhao.springblog.util;

import lombok.Data;

//the common structure of response json
@Data
public class CommonRest {

    private Integer status = 1;

    private String errorCode = "";

    private String errorMsg = "";

    private Object responseBody;

    public CommonRest(Object response){
        this.responseBody = response;
    }
    
}