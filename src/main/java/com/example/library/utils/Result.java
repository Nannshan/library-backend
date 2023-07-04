package com.example.library.utils;

import java.util.HashMap;
import java.util.Map;

public class Result {
    private Map<String, Object> data;
    private boolean success;
    private String message;
    private Integer code;

    // 把构造方法私有
    private Result(){}

    // 成功静态方法
    public static Result ok(){
        Result r = new Result();
        r.setSuccess(true);
        r.setCode(ResultCode.SUCCESS);
        r.setMessage("成功");
        return r;
    }

    // 失败静态方法
    public static Result error(){
        Result r = new Result();
        r.setSuccess(false);
        r.setCode(ResultCode.ERROR);
        r.setMessage("失败");
        return r;
    }

    public static Result tokenError(){
        Result r = new Result();
        r.setSuccess(false);
        r.setCode(ResultCode.TOKENFALSE);
        r.setMessage("失败");
        return r;
    }
    // 设置数据
    public Result data(String key, Object object){
        Map<String, Object> resultData = new HashMap<>();
        resultData.put(key, object);
        this.setData(resultData);
        return this;
    }
    public void setData(Map<String, Object> data){ this.data = data; }
    public Map<String, Object> getData() {
        return data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
