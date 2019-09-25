package com.enjoy.lazy.config;

import com.enjoy.bean.javabean.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * @description: 配置类
 * @author: lij
 * @create: 2019-09-14 17:41
 */

@Slf4j
@Configuration
public class MainConfig4 {

    /**
     * 懒加载，针对单实例bean
     * 容器启动的时候不创建对象，仅当第一次获取时才创建对象
     * **/
    @Lazy
    @Bean
    public Person person(){
        log.info("向容器中添加person对象");
        return new Person();
    }
}
