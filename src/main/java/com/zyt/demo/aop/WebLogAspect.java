package com.zyt.demo.aop;

import com.google.common.base.Joiner;
import com.zyt.demo.entity.User;
import com.zyt.demo.service.impl.IUserService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author tanner
 * @Date 2019/9/18
 */
@Component
@Aspect
public class WebLogAspect {
    @Autowired
    private IUserService userService;
    private static final Logger logger = LoggerFactory
            .getLogger(WebLogAspect.class);

    ThreadLocal<Long> startTimeThreadLocal = new ThreadLocal<Long>();

    @Pointcut("execution(* com.zyt.demo.controller.UserController.getUserLog(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void doBefore() throws Throwable {
        startTimeThreadLocal.set(System.currentTimeMillis());
    }

    @AfterReturning(pointcut = "webLog()")
    public void doAfterReturning(JoinPoint joinPoint) throws Throwable {
        //尝试利用切平面进行持久化操作
        List<User> users = userService.getAllRol();
        System.err.println(users);
        long usedTime = System.currentTimeMillis() - startTimeThreadLocal.get();
        Object[] arr = joinPoint.getArgs();
        List<Object> list = new ArrayList<>();
        for(Object obj : arr){
            if(obj == null){
                continue;
            }
            if(obj instanceof HttpServletRequest || obj instanceof HttpServletResponse){
                continue;
            }
            list.add(obj.toString());
        }
        String args = Joiner.on(",").join(list);
        String key = String.format("method=[%s.%s]",
                joinPoint.getSignature().getDeclaringType().getSimpleName(),
                joinPoint.getSignature().getName());
        //判断耗时超过15ms时可进行DEBUG调试优化代码
        if(usedTime > 15){
            logger.info(String.format("method=[%s],args=[%s] use time=%d ms",key, args, usedTime));
        } else if(logger.isDebugEnabled()){
            logger.debug(String.format("method=[%s],args=[%s] use time=%d ms",key, args)+"[{}]", usedTime);
        }

    }
    /*@Around("execution(* com.zyt.demo.controller.*.*(..))")
    public Object a(ProceedingJoinPoint joinPoint) throws Throwable {
        // 记录起始时间
        startTimeThreadLocal.set(System.currentTimeMillis());

        // 调用对应的业务方法
        Object o = joinPoint.proceed();

        // 记录结束时间
        long end = System.currentTimeMillis();

        // 计算耗时
        System.err.println("耗时：" + (end - startTimeThreadLocal.get()) + "ms.");
        long usedTime = System.currentTimeMillis() - startTimeThreadLocal.get();
        Object[] arr = joinPoint.getArgs();
        List<Object> list = new ArrayList<>();
        for(Object obj : arr){
            if(obj == null){
                continue;
            }
            if(obj instanceof HttpServletRequest || obj instanceof HttpServletResponse){
                continue;
            }
            list.add(obj.toString());
        }
        String args = Joiner.on(",").join(list);
        String key = String.format("method=[%s.%s]",
                joinPoint.getSignature().getDeclaringType().getSimpleName(),
                joinPoint.getSignature().getName());
        if(usedTime > 100){
            logger.info(String.format("method=[%s],args=[%s] use time=%d ms",key, args, usedTime));
        } else if(logger.isDebugEnabled()){
            logger.debug(String.format("method=[%s],args=[%s] use time=%d ms",key, args, usedTime));
        }
        //logger.info(String.format("method=[%s],args=[%s] use time=%d ms",key, args, usedTime));

        // 返回
        return o;
    }*/
}
