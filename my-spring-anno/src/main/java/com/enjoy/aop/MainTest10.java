package com.enjoy.aop;

import com.enjoy.aop.config.MainConfig10;
import com.enjoy.aop.javabean.Caculator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @description: aop测试类
 * @author: lij
 * @create: 2019-09-16 16:22
 */
public class MainTest10 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig10.class);
        System.out.println("IOC容器初始化完成");

        Caculator caculator = context.getBean(Caculator.class);
        caculator.div(6, 2);

        context.close();
    }
}
