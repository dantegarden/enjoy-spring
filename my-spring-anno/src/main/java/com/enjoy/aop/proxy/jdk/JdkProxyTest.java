package com.enjoy.aop.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @description:
 * @author: lij
 * @create: 2019-09-18 15:49
 */
public class JdkProxyTest {

    private static Star getProxy(ClassLoader classLoader, InvocationHandler invocationHandler){
        Object proxy = Proxy.newProxyInstance(classLoader, Idol.class.getInterfaces(), invocationHandler);
        System.out.println(proxy.getClass());
        return (Star) proxy;
    }

    public static void main(String[] args) {
        Star asuka = new Idol("斋藤飞鸟");
        StarProxy starProxy = new StarProxy(asuka);
        getProxy(JdkProxyTest.class.getClassLoader(), starProxy).sing();
    }
}
