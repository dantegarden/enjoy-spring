package com.enjoy.componentScan.config;

import com.enjoy.componentScan.annotationFilter.MyTypeFilter;
import com.enjoy.componentScan.controller.OrderController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @description: 配置类
 * @author: lij
 * @create: 2019-09-14 00:26
 */
@Configuration
//@ComponentScan(value = "com.enjoy.componentScan")

/**
 * useDefaultFilters = true（默认）会把所有@Component注解的类都扫描进来
 * **/

//@ComponentScan(value = "com.enjoy.componentScan", includeFilters = {
//        @ComponentScan.Filter(type= FilterType.ANNOTATION, classes = {Controller.class}) //只扫描@Controller注解的类
//}, useDefaultFilters = false)

//@ComponentScan(value = "com.enjoy.componentScan", excludeFilters = {
//        @ComponentScan.Filter(type= FilterType.ANNOTATION, classes = {Controller.class}) //不扫描@Controller注解的类
//}, useDefaultFilters = true)

//@ComponentScan(value = "com.enjoy.componentScan", includeFilters = {
//        @ComponentScan.Filter(type= FilterType.ASSIGNABLE_TYPE, classes = {OrderController.class}) //只扫描OrderController这个类
//}, useDefaultFilters = false)

//@ComponentScan(value = "com.enjoy.componentScan", includeFilters = {
//        @ComponentScan.Filter(type= FilterType.CUSTOM, classes = {MyTypeFilter.class}) //使用自定义的注解过滤器
//}, useDefaultFilters = false)

@ComponentScans({
        @ComponentScan(value = "com.enjoy.componentScan", includeFilters = {
                @ComponentScan.Filter(type= FilterType.CUSTOM, classes = {MyTypeFilter.class}) //使用多个@ComponentScans
        }, useDefaultFilters = false)
})
public class MainConfig2 {
}
