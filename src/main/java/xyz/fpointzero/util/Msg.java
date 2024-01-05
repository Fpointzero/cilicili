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
    private int status;
    private T data;
    private String msg;

    public Msg() {
    }

    public Msg(int status, T data, String msg) {
        this.status = status;
        this.data = data;
        this.msg = msg;
    }

    public Msg(int status, T data) {
        this.status = status;
        this.data = data;
        if (status == SUCCESS)
            this.msg = "请求成功";
        else
            this.msg = "请求失败";
    }

    public String toJSONString() {
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

    public Msg setAll(int status, T data, String msg) {
        this.status = status;
        this.data = data;
        this.msg = msg;
        return this;
    }
    public Msg setAll(int status, T data) {
        this.status = status;
        this.data = data;
        if (status == SUCCESS)
            this.msg = "请求成功";
        else
            this.msg = "请求失败";
        return this;
    }

    public void send(HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.getWriter().println(this.toJSONString());
    }
}
