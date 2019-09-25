package com.enjoy.autowire;

import com.enjoy._value.javabean.Bird2;
import com.enjoy.autowire.config.MainConfig9;
import com.enjoy.autowire.dao.TestDao;
import com.enjoy.autowire.service.TestService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.inject.Inject;

/**
 * @description:
 * @author: lij
 * @create: 2019-09-16 16:22
 */
public class MainTest9 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig9.class);
        System.out.println("IOC容器初始化完成");
        TestService testService = context.getBean(TestService.class);
        //自动注入的是哪个dao
        testService.test();
//        TestDao testDao = context.getBean(TestDao.class); //按类型取，但有两个类型相同id不同的bean，报错
//        System.out.println(testDao);

        System.out.println("------------------------");
        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }

        context.close();

    }
}
