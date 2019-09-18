package com.zyt.demo.serviceTest;

import com.zyt.demo.entity.JobInfo;
import com.zyt.demo.service.JobInfoServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JobInfoTest {
    @Autowired
    JobInfoServiceImpl service;
    @Test
    public void getJobInfo(){
        List<JobInfo> list = service.getJobInfo();
        for(JobInfo j:list){
            System.err.println(j);
        }
    }
}
