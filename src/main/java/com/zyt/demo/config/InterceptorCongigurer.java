package com.zyt.demo.config;

import java.util.ArrayList;
import java.util.List;

import com.zyt.demo.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorCongigurer implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 创建拦截器对象
		HandlerInterceptor interceptor = new LoginInterceptor();

		// 白名单
		List<String> patterns = new ArrayList<>();
		// 注册拦截器
		registry.addInterceptor(interceptor)
		.addPathPatterns("/statics/pages/main.html")
		.excludePathPatterns(patterns);
	}

}
