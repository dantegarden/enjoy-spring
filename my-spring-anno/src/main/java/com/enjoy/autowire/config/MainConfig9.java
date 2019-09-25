package com.enjoy.autowire.config;

import com.enjoy.autowire.dao.TestDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @description:
 * @author: lij
 * @create: 2019-09-16 16:20
 */
@Configuration
@ComponentScan("com.enjoy.autowire")
public class MainConfig9 {

    /**name和type完全一致的注册**/
    @Bean
    public TestDao testDao(){
        TestDao testDao = new TestDao();
        testDao.setFlag(1);
        return testDao;
    }

    /**name不一致 type一致的注册**/
    @Bean("testDao2")
    public TestDao testDao2(){
        TestDao testDao = new TestDao();
        testDao.setFlag(2);
        return testDao;
    }

    /**name不一致 type一致的注册，但优先级更高**/
    @Primary
    @Bean("testDao3")
    public TestDao testDao3(){
        TestDao testDao = new TestDao();
        testDao.setFlag(3);
        return testDao;
    }

}
