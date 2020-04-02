package com.fangshuo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
//import org.apache.log4j.Logger;

@Aspect
@Component
public class WebLogAspect {
//    private Logger logger = Logger.getLogger(getClass());

    @Pointcut("execution(public * com.fangshuo.controller.mainTest.main(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void doBefore() {
      System.out.println("Before");

    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        System.out.println("AfterReturning");
    }
}

