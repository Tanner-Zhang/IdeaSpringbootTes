package com.zyt.demo.service.impl;

import com.zyt.demo.service.ex.JobInfoNotFoundException;
import com.zyt.demo.entity.JobInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 职位信息业务层相关接口
 */
@Repository
public interface JobInfoService {
    /*
    查找所有职位详细信息
     */
    public List<JobInfo> getJobInfo() throws JobInfoNotFoundException;
}
