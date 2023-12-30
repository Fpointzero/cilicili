package xyz.fpointzero.util;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Msg<T> {
    private int status;
    private T data;
    private String msg;

    public Msg(){}

    public Msg(int status, T data, String msg) {
        this.status = status;
        this.data = data;
        this.msg = msg;
    }

    public String toJSONString(){
        return JSON.toJSONString(this);
    }

    public T getData() {
        return data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setAll(int status, T data, String msg) {
        this.status = status;
        this.data = data;
        this.msg = msg;
    }
}
