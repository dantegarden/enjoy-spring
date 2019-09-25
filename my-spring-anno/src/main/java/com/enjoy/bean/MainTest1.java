package com.enjoy.bean;

import com.enjoy.bean.javabean.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description: 最原始的配置文件使用方法
 * @author: lij
 * @create: 2019-09-14 00:06
 */
public class MainTest1 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Person person = (Person) context.getBean("person");
        System.out.println(person);
        Person person2 = (Person) context.getBean("person2");
        System.out.println(person2);
    }
}
