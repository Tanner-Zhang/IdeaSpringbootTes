package com.cy.demo.entity;

import java.io.Serializable;
import java.util.Date;

public class JobInfo implements Serializable {
    private static final long serialVersionUID = 164459385269556945L;
    private int deptNo;
    private String job;
    private String dName;
    private String status;
    private Date createTime;
    private String createUser;
    private String modifyTime;
    private String modifyUser;

    public int getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    @Override
    public String toString() {
        return "JobInfo{" +
                "deptNo=" + deptNo +
                ", job='" + job + '\'' +
                ", dName='" + dName + '\'' +
                ", status='" + status + '\'' +
                ", createTime=" + createTime +
                ", createUser='" + createUser + '\'' +
                ", modifyTime='" + modifyTime + '\'' +
                ", modifyUser='" + modifyUser + '\'' +
                '}';
    }
}
