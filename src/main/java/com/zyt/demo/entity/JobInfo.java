package com.zyt.demo.entity;

public class JobInfo extends BaseEntity {
    private static final long serialVersionUID = 5653632804575308963L;
    private int deptNo;
    private String job;
    private String dName;
    private String loc;
    private String status;

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

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "JobInfo{" +
                "deptNo=" + deptNo +
                ", job='" + job + '\'' +
                ", dName='" + dName + '\'' +
                ", loc='" + loc + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
