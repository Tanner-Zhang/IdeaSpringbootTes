package com.cy.demo.controller;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class test1 {
    public static void main(String[] args) {

        String key ="123";
        JwtBuilder jwtBuilder = Jwts.builder()
                .setId("1")
                .setSubject("1")
                .claim("username","1")
                .claim("password","1")
                .setIssuedAt( new Date())//登录时间-也就是签发时间（签发给你token的时间）
                .setExpiration(new Date(new Date().getTime() + (60 * 1000 *60)))//设置过期时间-一分钟
                .signWith(SignatureAlgorithm.HS256, key.getBytes())//设置签名秘钥
                /** token添加自定义属性 **/
                .claim("role", "admin");//设置用户角色

        String token = jwtBuilder.compact();

        Claims claims = Jwts.parser()
                .setSigningKey("123".getBytes())
                .parseClaimsJws(token)
                .getBody();

        String b=claims.getSubject();
        System.out.println(b);


       // new Thread(() -> System.out.println("It's A lambda function!")).start();




    }
}
