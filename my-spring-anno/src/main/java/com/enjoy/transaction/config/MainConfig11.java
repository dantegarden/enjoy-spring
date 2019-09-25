package com.enjoy.transaction.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @description:
 * @author: lij
 * @create: 2019-09-20 14:17
 */
@Configuration
@ComponentScan({"com.enjoy.transaction"})
@EnableTransactionManagement //开启事务管理功能，对@Tranctional注解起作用
public class MainConfig11 {

    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        //c3p0封装了JDBC，dataSource接口的实现
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://192.168.3.200:3306/seckill?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8");
        dataSource.setUser("root");
        dataSource.setPassword("123456");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() throws PropertyVetoException {
        return new JdbcTemplate(dataSource());
    }

    /**注册事务管理器*/
    @Bean
    public PlatformTransactionManager platformTransactionManager() throws PropertyVetoException {
        return new DataSourceTransactionManager(dataSource());
    }
}
