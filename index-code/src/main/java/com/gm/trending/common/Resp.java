package com.gm.trending.common;

import java.io.Serializable;
import java.util.Map;

/**
 * @author Squirrel-Chen
 */
public class Resp implements Serializable {

    private static final long serialVersionUID = -2083301101317223782L;
    private String code;
    private String msg;
    private Map<String, Object> data;

    @Override
    public String toString() {
        return "Resp{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public Resp(String code, String msg, Map<String, Object> data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object>  data) {
        this.data = data;
    }


}
