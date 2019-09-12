package com.zyt.demo.dao;

import com.zyt.demo.entity.JobInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 职位信息相关接口
 */
@Repository
public interface JobInfoMapper {
    /**
     * 查询所有职位信息
     * @return 返回查询结果集
     */
    public List<JobInfo> findJobInfo();
}
