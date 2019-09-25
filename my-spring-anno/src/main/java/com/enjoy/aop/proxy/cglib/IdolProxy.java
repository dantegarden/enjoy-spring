package com.enjoy.aop.proxy.cglib;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @description:
 * @author: lij
 * @create: 2019-09-18 16:39
 */
@Slf4j
public class IdolProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        if(!method.getName().startsWith("set") && !method.getName().startsWith("get"))
        log.info("收订金");
        Object result = methodProxy.invokeSuper(proxy, args);
        if(!method.getName().startsWith("set") && !method.getName().startsWith("get"))
        log.info("收全款");
        return result;
    }
}
