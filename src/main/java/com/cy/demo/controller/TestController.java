package com.cy.demo.controller;



import com.cy.demo.dao.Mapper;
import com.cy.demo.entity.User;
import com.cy.demo.util.JwtUtil;
import com.cy.demo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import com.cy.demo.service.impl.RedisTestService;


@Controller
public class TestController {

@Autowired
private Mapper mapper;

@Autowired
private RedisTestService  redisTestService;


@Autowired
private RedisTemplate<Object,Object> redisTemplate;


    @RequestMapping(value = "/test1",method = RequestMethod.GET)
    public void test(){
        String name ="aa";
//      this.mapper.test(name);
    }

    @RequestMapping(value="/",method=RequestMethod.POST)
    @ResponseBody
    public Result test(String username, String password, HttpServletResponse response) {


        System.out.println(username);
        System.out.println(password);


        User user = new User();
        user.setUsername(username);
        user.setPassword(password);


        JwtUtil jwtUtil = new JwtUtil();
        String token =jwtUtil.tokenBuild(username, password);
        Cookie cookie = new Cookie("token", token);
        response.addCookie(cookie);

       // redisTemplate.boundListOps(username).rightPush(user);

        redisTemplate.boundListOps(username).rightPush(token);



        return null;

    }

    @RequestMapping(value="/getToken",method=RequestMethod.GET)
    public void getToken(HttpServletRequest request) {
        //获取token
        Cookie [] cookies =request.getCookies();
        Map<String, Object> cookieMap = new HashMap();
        for(Cookie ck : cookies){
            cookieMap.put(ck.getName(),ck.getValue());
        }



        //1
        for(String k:cookieMap.keySet()){
            System.out.println("key:"+k+"value"+cookieMap.get(k));
        }


        String key=null;
        String value=null;
        //2
        for (Map.Entry<String, Object> entry : cookieMap.entrySet()) {
            key = entry.getKey();
            value = entry.getValue().toString();
            System.out.println("key=" + key + " value=" + value);
        }
        String token=value;


       //this.redisTestService.redisTest(token);



    }

    @RequestMapping(value="/redisTest",method=RequestMethod.GET)
    @ResponseBody
    public User redisTest(String username) {

       User user = this.redisTestService.redisTest(username);



      return user;

    }







}
