package com.zyt.demo.controller;

import com.zyt.demo.entity.JobInfo;
import com.zyt.demo.service.JobInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class JobInfoController {
    @Autowired
    JobInfoServiceImpl jobInfoService;
    @RequestMapping("/statics/pages/jobInfo")
    @ResponseBody
    public Map<String,Object> jobInfo(){
        Map<String,Object> map = new HashMap<>();
        List<JobInfo> list = new ArrayList<>();
        list = jobInfoService.getJobInfo();
        map.put("total",list.size());
        map.put("rows",list);
        return map;
    }
}
