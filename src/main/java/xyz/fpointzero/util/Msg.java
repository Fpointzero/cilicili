package xyz.fpointzero.util;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Msg<T> {
    public static final int ERROR = 400;
    public static final int SUCCESS = 200;
    private int code;
    private T data;
    private String message;

    public Msg() {
    }

    public Msg(int status, T data, String msg) {
        this.code = status;
        this.data = data;
        this.message = msg;
    }

    public Msg(int status, T data) {
        this.code = status;
        this.data = data;
        if (status == SUCCESS)
            this.message = "请求成功";
        else
            this.message = "请求失败";
    }

    public String toJSONString() {
        return JSON.toJSONString(this);
    }

    public T getData() {
        return data;
    }

    public int getStatus() {
        return code;
    }

    public void setStatus(int status) {
        this.code = status;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return message;
    }

    public void setMsg(String msg) {
        this.message = msg;
    }

    public Msg setAll(int status, T data, String msg) {
        this.code = status;
        this.data = data;
        this.message = msg;
        return this;
    }
    public Msg setAll(int status, T data) {
        this.code = status;
        this.data = data;
        if (status == SUCCESS)
            this.message = "请求成功";
        else
            this.message = "请求失败";
        return this;
    }

    public void send(HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.getWriter().println(this.toJSONString());
    }
}
