package com.enjoy.lazy;

import com.enjoy.bean.javabean.Person;
import com.enjoy.lazy.config.MainConfig4;
import javafx.application.Application;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @description: lazy测试
 * @author: lij
 * @create: 2019-09-14 17:42
 */
public class MainTest4 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig4.class);
        System.out.println("IOC容器创建完成");
        Arrays.asList(context.getBeanDefinitionNames()).forEach(System.out::println);
        System.out.println("-----");
        Person person = (Person) context.getBean("person");
        Arrays.asList(context.getBeanDefinitionNames()).forEach(System.out::println);
    }
}
