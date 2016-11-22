package com.example.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/10/26.
 */
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler"})
//@JsonIgnoreProperties(ignoreUnknown=true)
public class MVCResult implements Serializable{
    private static final long serialVersionUID = 4471107521461776782L;
    private String message;
    private Object data;
    private Type result;
    public enum Type{
        /** 成功*/
        OK,
    }
    public MVCResult(Type result,Object data) {
        this.data = data;
        this.result=result;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
