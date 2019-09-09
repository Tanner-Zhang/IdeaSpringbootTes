package com.cy.demo.service;

import com.cy.demo.service.impl.RedisTestService;
import com.cy.demo.entity.User;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;




import io.jsonwebtoken.Jwts;

@Service
public class ServiceImpl implements RedisTestService {

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Override
    public User redisTest(String username) {
      /*  Claims claims = Jwts.parser()
                .setSigningKey("123")
                .parseClaimsJws(token)
                .getBody();

        claims.get("username");
        claims.get("password");*/

      String token1=  (String)redisTemplate.boundListOps(username).index(-1);

      System.out.println(token1);

      String key ="123";

      Claims claims = Jwts.parser()
                .setSigningKey(key.getBytes())
                .parseClaimsJws(token1)
                .getBody();

       String username1= (String) claims.get("username");
       String password= (String) claims.get("password");

       System.out.println("username:"+username1+"~"+"password:"+password);

       User user =new User();
       user.setUsername(username1);
       user.setPassword(password);

       return user;
    }
}
