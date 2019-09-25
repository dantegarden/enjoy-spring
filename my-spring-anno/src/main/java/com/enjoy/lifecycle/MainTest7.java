package com.enjoy.lifecycle;

import com.enjoy.bean.javabean.Person;
import com.enjoy.lifecycle.config.MainConfig7;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @description: 生命周期测试
 * @author: lij
 * @create: 2019-09-14 17:42
 */
public class MainTest7 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig7.class);
        System.out.println("IOC容器创建完成");
        context.getBean("order");
        context.close();
        System.out.println("IOC容器已销毁");
    }
}
