package com.enjoy._import;

import com.enjoy._import.config.MainConfig6;
import com.enjoy._import.factory.MyFactoryBean;
import com.enjoy.conditional.config.MainConfig5;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @description: conditional测试
 * @author: lij
 * @create: 2019-09-14 17:42
 */
public class MainTest6 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig6.class);
        System.out.println("IOC容器创建完成");

        Object object = context.getBean("myFactoryBean");
        System.out.println("bean的类型：" + object.getClass());
        Object object2 = context.getBean("myFactoryBean");
        System.out.println((object == object2));
        Arrays.asList(context.getBeanDefinitionNames()).forEach(System.out::println);

    }
}
