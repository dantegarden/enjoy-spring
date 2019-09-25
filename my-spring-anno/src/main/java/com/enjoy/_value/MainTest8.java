package com.enjoy._value;

import com.enjoy._import.config.MainConfig6;
import com.enjoy._value.config.MainConfig8;
import com.enjoy._value.javabean.Bird;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @description: value测试
 * @author: lij
 * @create: 2019-09-14 17:42
 */
public class MainTest8 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig8.class);
        System.out.println("IOC容器创建完成");
        Bird bird = context.getBean(Bird.class);
        System.out.println(bird);

        System.out.println("---------------");
        Arrays.asList(context.getBeanDefinitionNames()).forEach(System.out::println);
        System.out.println("----------------");
        System.out.println(context.getEnvironment().getProperty("bird.color"));
    }
}
