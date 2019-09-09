package com.cy.demo.util;

import java.util.Date;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {

	public String tokenBuild(String username,String password) {


		String key ="123";
		JwtBuilder jwtBuilder = Jwts.builder()
				.setId(username)
				.setSubject(username)
				.claim("username",username)
				.claim("password",password)
				.setIssuedAt( new Date())//登录时间-也就是签发时间（签发给你token的时间）
				.setExpiration(new Date(new Date().getTime() + (60 * 1000 *60*60)))//设置过期时间-一分钟
				.signWith(SignatureAlgorithm.HS256, key.getBytes());//设置签名秘钥

		//System.out.println(jwtBuilder.compact());
		String token = jwtBuilder.compact();
		System.out.println(token);
		return token;	
	}
	
}
