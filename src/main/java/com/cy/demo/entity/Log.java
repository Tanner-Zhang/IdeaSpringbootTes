package com.cy.demo.entity;

import java.io.Serializable;
import java.util.Date;

public class Log implements Serializable {
    private Date createTime;
    private String userName;
    private String IP;
    private String serviceName;
    private String operation;
    private String description;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Log{" +
                "createTime=" + createTime +
                ", userName='" + userName + '\'' +
                ", IP='" + IP + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", operation='" + operation + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
