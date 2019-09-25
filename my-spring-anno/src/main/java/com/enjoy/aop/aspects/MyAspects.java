package com.enjoy.aop.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: lij
 * @create: 2019-09-19 17:37
 */
@Component
@Aspect
@Slf4j
public class MyAspects {
    /**
     * 声明切面
     * @param
     * @return: void
     */
    //    @Pointcut("execution(public int com.enjoy.aop.javabean.Caculator.div(int, int)")
    @Pointcut("execution(public int com.enjoy.aop.javabean.MyBook.*(..))")
    public void pointCut(){

    }

    //指定目标方法，在执行前切入

    @Before("pointCut()")
    private void logStart(JoinPoint joinPoint){
        log.info("@Before：{}方法开始，入参：{}", joinPoint.getSignature().getName(), joinPoint.getArgs());
    }

    @After("pointCut()")
    private void logEnd(JoinPoint joinPoint){
        log.info("@After：{}方法结束", joinPoint.getSignature().getName());
    }
}
