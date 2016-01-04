package com.liuping.common;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Created by liuping on 15/12/9.
 */
public class ApiResult {

    private String code;

    private String message;

    private Object result;

    public String getCode() {
        if (code == null){
            return "";
        }
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        if (message == null) {
            return "";
        }
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        if (result instanceof JSONObject && result == null){
            return new JSONObject();
        }
        if (result instanceof JSONArray && result == null) {
            return new JSONArray();
        }
        if (result == null) {
            result = "";
        }
        return result;
    }

    public void setResult(Object result) {

        this.result = result;
    }
}
