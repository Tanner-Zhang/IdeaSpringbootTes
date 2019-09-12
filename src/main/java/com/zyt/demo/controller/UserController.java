package com.zyt.demo.controller;


import com.zyt.demo.entity.Log;
import com.zyt.demo.entity.User;
import com.zyt.demo.service.impl.IUserService;
import com.zyt.demo.service.impl.LoginService;
import com.zyt.demo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
