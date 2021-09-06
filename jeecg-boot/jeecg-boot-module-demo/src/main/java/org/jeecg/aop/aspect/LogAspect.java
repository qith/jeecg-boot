package org.jeecg.aop.aspect;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LogAspect {

    private Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Before("execution(* org.jeecg.aop.pojo.impl.MyLogPrint.doPrint(..))")
    public void before(){
        System.out.println("before log");
    }

    @After("execution(* org.jeecg.aop.pojo.impl.MyLogPrint.doPrint(..))")
    public void after(){
        System.out.println("after log");
    }

    @AfterReturning("execution(* org.jeecg.aop.pojo.impl.MyLogPrint.doPrint(..))")
    public void afterReturning(){
        System.out.println("afterReturning log");
    }

    @AfterThrowing("execution(* org.jeecg.aop.pojo.impl.MyLogPrint.doPrint(..))")
    public void afterThrowing(){
        System.out.println("afterThrowing log");
    }



}
