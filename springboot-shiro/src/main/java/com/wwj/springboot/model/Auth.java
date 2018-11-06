package com.wwj.springboot.model;

import java.io.Serializable;
import java.util.Date;

public class Auth implements Serializable {

    private String authName;
    private String authUrl;
    private String authUniqueMark;
    private Date createTime;
    private String methodType;

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    public String getAuthUrl() {
        return authUrl;
    }

    public void setAuthUrl(String authUrl) {
        this.authUrl = authUrl;
    }

    public String getAuthUniqueMark() {
        return authUniqueMark;
    }

    public void setAuthUniqueMark(String authUniqueMark) {
        this.authUniqueMark = authUniqueMark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getMethodType() {
        return methodType;
    }

    public void setMethodType(String methodType) {
        this.methodType = methodType;
    }
}