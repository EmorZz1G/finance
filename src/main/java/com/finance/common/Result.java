package com.finance.common;

import java.util.HashMap;
import java.util.Map;

public class Result {
    private int code;

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

    public Result add(String key,Object value){
        this.extend.put(key,value);
        return this;
    }
    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", extend=" + extend +
                '}';
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
