package com.enjoy.conditional;

import com.enjoy.bean.javabean.Person;
import com.enjoy.conditional.config.MainConfig5;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @description: conditional测试
 * @author: lij
 * @create: 2019-09-14 17:42
 */
public class MainTest5 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig5.class);
        System.out.println("IOC容器创建完成");
        Arrays.asList(context.getBeanDefinitionNames()).forEach(System.out::println);

    }
}
