package com.enjoy.extend;

import com.enjoy.bean.javabean.Person;
import com.enjoy.extend.config.MainConfig12;
import com.enjoy.extend.javabean.Moon;
import com.enjoy.lazy.config.MainConfig4;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @description: 扩展测试
 * @author: lij
 * @create: 2019-09-14 17:42
 */
public class MainTest12 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig12.class);
        System.out.println("IOC容器创建完成");

        Moon moon = (Moon) context.getBean("moon");

        context.close();
    }
}
