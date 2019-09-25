package com.enjoy.conditional.config;

import com.enjoy.bean.javabean.Person;
import com.enjoy.conditional.condition.LinuxCondition;
import com.enjoy.conditional.condition.WinCondition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 配置类
 * @author: lij
 * @create: 2019-09-14 20:57
 */
@Slf4j
@Configuration
public class MainConfig5 {

    @Bean("person")
    public Person person(){
        log.info("向容器中添加person对象");
        return new Person();
    }

    /**
     * 在bean注入到ioc容器前，先执行@Conditional里的matches方法，只有返回为true时才能注入成功
     * **/
    @Conditional(WinCondition.class)
    @Bean("lison")
    public Person lison(){
        log.info("向容器中添加lison对象");
        return new Person("lison", 58);
    }

    @Conditional(LinuxCondition.class)
    @Bean("james")
    public Person james(){
        log.info("向容器中添加james对象");
        return new Person("james", 12);
    }
}
