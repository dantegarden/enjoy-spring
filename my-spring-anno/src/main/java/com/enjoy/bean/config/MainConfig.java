package com.enjoy.bean.config;

import com.enjoy.bean.javabean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 使用注解的配置类，等同于xml配置文件
 * @author: lij
 * @create: 2019-09-14 00:11
 */
@Configuration
public class MainConfig {

    //给容器注册一个bean，类型是返回值类型, id是方法名
    @Bean
    public Person person(){
        return new Person("lij", 20);
    }

    //也可以指定id
    @Bean("person2")
    public Person person_xx(){
        return new Person("lij", 21);
    }
}
