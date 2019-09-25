package com.enjoy.bean;

import com.enjoy.bean.javabean.Person;
import com.enjoy.bean.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @description: 使用注解
 * @author: lij
 * @create: 2019-09-14 00:13
 */
public class MainTest2 {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        Person person = (Person) context.getBean("person");
        System.out.println(person);
        Person person2 = (Person) context.getBean("person2");
        System.out.println(person2);
        String[] beanNamesForType = context.getBeanNamesForType(Person.class);
        Arrays.asList(beanNamesForType).forEach(System.out::println);
    }
}
