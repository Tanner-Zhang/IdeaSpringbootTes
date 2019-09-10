package com.cy.demo.controller;


import com.cy.demo.service.impl.LoginService;
import com.cy.demo.service.impl.IUserService;
import com.cy.demo.entity.JobInfo;
import com.cy.demo.entity.Log;
import com.cy.demo.entity.User;
import com.cy.demo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
public class UserController {

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;
    @Autowired
    private LoginService loginService;
    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Result login(String username, String password, HttpServletResponse response){

           System.out.println(username+"~~~"+password);

           User user =new User();
           user.setUsername(username);
           user.setPassword(password);

           Result result=this.loginService.login(username,password);
            //登陆成功
           if (result.getStatus()==1){

               /*JwtUtil jwtUtil =new JwtUtil();
               String token =jwtUtil.tokenBuild(username, password);
               Cookie cookie = new Cookie("token", token);
               response.addCookie(cookie);

               redisTemplate.boundListOps(username).rightPush(token);*/

           }

    return result;
    }
    @RequestMapping("/statics/pages/user")
    public String userList(ModelMap model){
        List<User> users = userService.getAllRol();
        System.err.println("1111111111111111111111");
        model.addAttribute("list",users);
        return "user";
    }

    @RequestMapping("/statics/pages/jobInfo")
    @ResponseBody
    public Map<String,Object> jobInfo(){
        Map<String,Object> map = new HashMap<>();
        List<JobInfo> list = new ArrayList<>();
        for(int i=1;i<4;i++){
            JobInfo jobInfo = new JobInfo();
            jobInfo.setDeptNo(i);
            jobInfo.setdName("采购部");
            jobInfo.setJob("采购部经理");
            jobInfo.setCreatedUser("admin");
            jobInfo.setCreatedTime(new Date());
            jobInfo.setLoc("测试阶段");
            list.add(jobInfo);
        }
        for(int i=4;i<8;i++){
            JobInfo jobInfo = new JobInfo();
            jobInfo.setDeptNo(i);
            jobInfo.setdName("人事部");
            jobInfo.setJob("人事部主管");
            jobInfo.setCreatedUser("admin");
            jobInfo.setCreatedTime(new Date());
            jobInfo.setLoc("测试阶段");
            list.add(jobInfo);
        }
        for(int i=8;i<12;i++){
            JobInfo jobInfo = new JobInfo();
            jobInfo.setDeptNo(i);
            jobInfo.setdName("财务部");
            jobInfo.setJob("会计");
            jobInfo.setCreatedUser("admin");
            jobInfo.setCreatedTime(new Date());
            jobInfo.setLoc("测试阶段");
            list.add(jobInfo);
        }
        map.put("total",11);
        map.put("rows",list);
        return map;
    }
    @RequestMapping("/statics/pages/userLog")
    public String getUserLog(ModelMap model) {
        List<Log> list = new ArrayList<>();
        Log log = new Log();
        Date date = new Date();
        for(int i=0;i<5;i++){
            log.setCreateTime(date);
            log.setDescription("无");
            log.setIP("128.168.1.172");
            log.setOperation("admin用户密码登录");
            log.setServiceName("用户密码登录");
            log.setUserName("admin");
            list.add(log);
        }
        model.addAttribute("logs",list);
        System.out.println(list);
        return "userLog";
    }
}
