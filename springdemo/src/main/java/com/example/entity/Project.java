package com.example.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/10/25.
 */
public class Project implements Serializable {
    private static final long serialVersionUID = 4471107521461776780L;
    /** 阿里云路径 */
    private String treePath;
    /** 项目编号 */
    private String code;
    /** 项目名称 */
    private String name;

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

    public String getTreePath() {
        return treePath;
    }

    public void setTreePath(String treePath) {
        this.treePath = treePath;
    }
}
