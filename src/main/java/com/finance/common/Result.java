package com.finance.common;

import java.util.HashMap;
import java.util.Map;

public class Result {
    private int code;
    private String msg;

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", extend=" + extend +
                '}';
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private Map<String,Object> extend = new HashMap<>();

    public Result() {
    }

    public Result(int code) {
        this.code = code;
    }

    public static Result success(){
        return new Result(100);
    }
    public static Result failure(){
        Result result = new Result();
        result.code = 200;
        return result;
    }

    public static Result success(String msg){
        Result result = new Result(100);
        result.setMsg(msg);
        return result;
    }

    public static Result failure(String msg){
        Result result = new Result(200);
        result.setMsg(msg);
        return result;
    }

    public Result add(String key,Object value){
        this.extend.put(key,value);
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }
}
