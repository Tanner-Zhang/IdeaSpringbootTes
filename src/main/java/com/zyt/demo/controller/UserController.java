package com.zyt.demo.controller;


import com.zyt.demo.dao.UserMapper;
import com.zyt.demo.entity.Log;
import com.zyt.demo.entity.User;
import com.zyt.demo.service.impl.IUserService;
import com.zyt.demo.service.impl.LoginService;
import com.zyt.demo.util.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author tanner
 * @Date 2019/9/16
 */
@Controller
public class UserController {

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;
    @Autowired
    private LoginService loginService;
    @Autowired
    private IUserService userService;
    @Autowired
    private UserMapper userMapper;
    @RequestMapping(value = "/notLogin", method = RequestMethod.GET)
    public String notLogin() {
        return "您尚未登陆！";
    }

    @RequestMapping(value = "/notRole", method = RequestMethod.GET)
    public String notRole() {
        return "您没有权限！";
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Result login(String username, String password, HttpServletRequest request){

        System.out.println(username+"~~~"+password);
        Result result = new Result();
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 执行认证登陆
        subject.login(token);
        //方法一:使用容器创建的session
        /*HttpSession session = request.getSession();
        session.setMaxInactiveInterval(3);
        session.setAttribute("username",username);*/
        //方法二:使用Subject获得session
        Session session = subject.getSession();
        session.setAttribute("username",username);
        session.setTimeout(10000);
        //根据权限，指定返回数据
        String role = userMapper.findByUserName(username).getRole();
        if ("管理员".equals(role)) {
            result = loginService.login(username, password);
            result.setMessage("欢迎登陆！");
        }else if ("超级管理员".equals(role)) {
            result = loginService.login(username, password);
            System.err.println("欢迎来到管理员页面");
        }else {
            result.setMessage("权限错误！");
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
