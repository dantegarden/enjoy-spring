package com.enjoy.extend.config;

import com.enjoy.extend.javabean.Moon;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: lij
 * @create: 2019-09-21 15:34
 */
@Configuration
@ComponentScan("com.enjoy.extend")
public class MainConfig12 {

    @Bean
    public Moon moon(){
        return new Moon();
    }

}
