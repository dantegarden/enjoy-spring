package com.enjoy.aop.proxy.jdk;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description: 被代理对象的包装类，它必须实现InvocationHandler
 * @author: lij
 * @create: 2019-09-18 15:42
 */
@Slf4j
public class StarProxy implements InvocationHandler {

    /**持有被代理对象*/
    private Star star;

    public StarProxy(Star star) {
        this.star = star;
    }

    /**被代理对象的任何方法都要通过invoke执行*/
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("收订金");
        Object result = method.invoke(star, args);
        log.info("收全款");
        return result;
    }

    /**获取代理对象*/
    public Star getProxy(){
        /**
         * JDK中规定代理对象不能直接持有被代理对象，只能持有InvocationHandler的实现类。
         * 因此需要对被代理对象进行包装，而且要实现InvocationHandler接口。
         *
         * 这里会动态创建一个完全崭新的代理类，这个类是Proxy的子类，并且实现了被代理对象的所有接口
         * 例如 public final class $ProxyXXXX extends Proxy implements Star
         * 它的创建需要三个参数：当前的classLoader，被代理对象的所有接口，以及被代理对象的包装类
         * 可以认为代理对象是InvocationHandler实现类的包装类，调代理对象的方法其实就是调InvocationHandler的invoke()
         * 而InvocationHandler实现类则是被代理的对象的包装类，所以总的来说是个二次包装的结构
         * 此处返回的就是代理类的实例
         * */
        return (Star) Proxy.newProxyInstance(getClass().getClassLoader(), star.getClass().getInterfaces(), this);
    }
}
