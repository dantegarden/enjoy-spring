package com.enjoy.componentScan;

import com.enjoy.bean.javabean.Person;
import com.enjoy.componentScan.config.MainConfig2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * @description: ComponentScan测试
 * @author: lij
 * @create: 2019-09-14 00:06
 */
public class MainTest3 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);
        Arrays.asList(context.getBeanDefinitionNames()).forEach(System.out::println);
    }
}
