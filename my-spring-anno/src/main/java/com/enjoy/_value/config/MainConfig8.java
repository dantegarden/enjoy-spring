package com.enjoy._value.config;

import com.enjoy._value.MyPropertySourceFactory;
import com.enjoy._value.javabean.Bird;
import com.enjoy._value.javabean.Bird2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @description: 配置类
 * @author: lij
 * @create: 2019-09-16 15:31
 */
@Configuration
@PropertySource(value = {"classpath:/_value.properties", "classpath:/_value.yml"}, factory = MyPropertySourceFactory.class)  //启动容器时加载到context.environment里
public class MainConfig8 {

    @Bean
    public Bird bird(){
        return new Bird();
    }
    @Bean
    public Bird2 bird2(){
        return new Bird2();
    }

}
