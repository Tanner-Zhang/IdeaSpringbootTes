package com.zyt.demo.service.impl;

import com.zyt.demo.dao.JobInfoMapper;
import com.zyt.demo.entity.JobInfo;
import com.zyt.demo.service.JobInfoService;
import com.zyt.demo.service.ex.JobInfoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class JobInfoServiceImple implements JobInfoService {
    @Autowired
    private JobInfoMapper mapper;
    private List<JobInfo> JobInfos = new ArrayList<>();
    @Override
    public List<JobInfo> getJobInfo() throws JobInfoNotFoundException {
        JobInfos = mapper.findJobInfo();
        return JobInfos;
    }
}
