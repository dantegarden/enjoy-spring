package com.enjoy.mvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @description: spring配置类 RootAC
 * @author: lij
 * @create: 2019-09-23 20:44
 */
@Configuration
@ComponentScan(value={"com.enjoy.mvc"}, excludeFilters = {
        @ComponentScan.Filter(type= FilterType.ANNOTATION, classes = {Controller.class})
}, useDefaultFilters = true)
public class MyRootConfig {
}
