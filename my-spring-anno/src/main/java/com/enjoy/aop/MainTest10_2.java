package com.enjoy.aop;

import org.omg.PortableInterceptor.Interceptor;

/**
 * @description: 演示切面的通知方法们是如何按顺序执行的
 * @author: lij
 * @create: 2019-09-19 17:57
 */
public class MainTest10_2 {
    static interface MyInterceptor {
        void invoke(MainTest10_2 ctx);
    }
    static class BeforeInterceptor implements MyInterceptor {
        @Override
        public void invoke(MainTest10_2 ctx) {
            System.out.println("BeforeInterceptor does it's work ");
            ctx.proceed();
        }
    }
    static class AfterInterceptor implements MyInterceptor {
        @Override
        public void invoke(MainTest10_2 ctx) {
            try{
                ctx.proceed();
            }finally {
                System.out.println("AfterInterceptor does it's work ");
            }
        }
    }
    static class ReturnInterceptor implements MyInterceptor {
        @Override
        public void invoke(MainTest10_2 ctx) {
            try{
                ctx.proceed();
            }finally {
                System.out.println("ReturnInterceptor does it's work ");
            }
        }
    }

    private int count = -1;
    private MyInterceptor[] interceptors;

    public MainTest10_2(MyInterceptor[] interceptors) {
        this.interceptors = interceptors;
    }

    public void proceed(){
        if(this.count + 1 > interceptors.length-1){
            targetMethod();
        }
        else{
            MyInterceptor interceptor = interceptors[++this.count];
            interceptor.invoke(this);
        }
    }

    private void targetMethod(){
        System.out.println("执行目标方法");
    }

    public static void main(String[] args) {

        MyInterceptor[] interceptors = new MyInterceptor[]{
                new ReturnInterceptor(),
                new AfterInterceptor(),
                new BeforeInterceptor()};
        MainTest10_2 mainTest10_2 = new MainTest10_2(interceptors);
        mainTest10_2.proceed();
     }
}
