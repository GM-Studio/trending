package com.gm.trending.entity;

import java.io.Serializable;

/**
 * @author Squirrel-Chen
 * @Name 证券指数
 */
public class Index implements Serializable {

    private static final long serialVersionUID = 4830653838298048342L;
    /**
     *  指数代码
     */
    private String code;
    /**
     *  指数名称
     */
    private String name;

    public Index(){}

    public Index(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Index{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
