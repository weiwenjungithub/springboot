package com.wwj.springboot.model;

import java.util.Date;

/**
 * Created by IntelliJ IDEA
 *
 * @author weiwenjun
 * @date 2018/9/12
 */
public class OperationLog {

    private String id;
    private Date createTime;
    private Integer level;
    private String operationUnit;
    private String method;
    private String args;
    private String userId;
    private String userName;
    private String describe;
    private String operationType;
    private Long runTime;
    private String returnValue;

    @Override
    public String toString() {
        return "OperationLog{" +
                "id='" + id + '\'' +
                ", createTime=" + createTime +
                ", level=" + level +
                ", operationUnit='" + operationUnit + '\'' +
                ", method='" + method + '\'' +
                ", args='" + args + '\'' +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", describe='" + describe + '\'' +
                ", operationType='" + operationType + '\'' +
                ", runTime=" + runTime +
                ", returnValue='" + returnValue + '\'' +
                '}';
    }

    public Long getRunTime() {
        return runTime;
    }

    public void setRunTime(Long runTime) {
        this.runTime = runTime;
    }

    public String getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(String returnValue) {
        this.returnValue = returnValue;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getOperationUnit() {
        return operationUnit;
    }

    public void setOperationUnit(String operationUnit) {
        this.operationUnit = operationUnit;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }
}
