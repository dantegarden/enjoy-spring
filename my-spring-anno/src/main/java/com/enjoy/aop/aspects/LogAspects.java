package com.enjoy.aop.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 切面类的方法可以动态感知到业务方法的运行
 * 通知方法：
 *  前置通知：在目标方法之前执行  @Before
 *  后置通知：在目标方法结束后（不管有无异常）执行 @After
 *  返回通知：在目标方法正常返回时执行 @AfterReturn
 *  异常通知：在目标方法抛出异常后执行 @AfterThrowing
 *  环绕通知：动态代理，需要手动安排执行目标方法的时机（执行joinPoint.procced()等同于执行目标方法） @Around
 * @return:
 */
@Component
@Aspect
@Slf4j
public class LogAspects {

    /**
     * 声明切面
     * @param
     * @return: void
     */
    //    @Pointcut("execution(public int com.enjoy.aop.javabean.Caculator.div(int, int)")
    @Pointcut("execution(public int com.enjoy.aop.javabean.Caculator.*(..))")
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

    @AfterReturning(value = "pointCut()", returning = "result")
    private void logReturn(JoinPoint joinPoint, Object result){
        log.info("@AfterReturing：{}方法正常返回，结果是：{}", joinPoint.getSignature().getName(), result);
    }

    @AfterThrowing(value = "pointCut()", throwing = "exception")
    private void logException(JoinPoint joinPoint, Exception exception){
        log.info("@AfterThrowing：{}方法发生异常，异常是：{}", joinPoint.getSignature().getName(), exception.getMessage());
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint){
        Object proceed = null;
        try {
            log.info("@Around：准备执行{}方法: 参数：{}", joinPoint.getSignature().getName(), joinPoint.getArgs());
            proceed = joinPoint.proceed();//相当于运行目标方法
            log.info("@Around：执行完毕： 结果：{}", proceed);
        } catch (Throwable throwable) {
//            throwable.printStackTrace();
            throw new RuntimeException(throwable);
        }
        return proceed;
    }
}
