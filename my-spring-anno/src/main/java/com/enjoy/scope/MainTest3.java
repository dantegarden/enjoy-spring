package com.enjoy.scope;

import com.enjoy.bean.javabean.Person;
import com.enjoy.scope.config.MainConfig3;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @description: scope测试类
 * @author: lij
 * @create: 2019-09-14 17:10
 */
public class MainTest3 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig3.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

        //取两次，证明是否用的同一个bean
        Person person = (Person) context.getBean("personm");
        System.out.println(person == context.getBean("personm"));
    }
}
