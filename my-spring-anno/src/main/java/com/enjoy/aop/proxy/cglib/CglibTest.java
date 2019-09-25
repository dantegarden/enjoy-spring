package com.enjoy.aop.proxy.cglib;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @description:
 * @author: lij
 * @create: 2019-09-18 16:41
 */
public class CglibTest {

    private static <T> T getProxy(Class<T> clazz, Class<? extends Callback> proxyClass) throws IllegalAccessException, InstantiationException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(proxyClass.newInstance());
        return (T)enhancer.create();
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Idol proxy = getProxy(Idol.class, IdolProxy.class);
        proxy.setName("斋藤飞鸟");
        proxy.sing();
    }
}
