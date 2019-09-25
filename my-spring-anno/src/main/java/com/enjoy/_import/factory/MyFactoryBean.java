package com.enjoy._import.factory;

import com.enjoy._import.javabean.Monkey;
import org.springframework.beans.factory.FactoryBean;

/**
 * @description: 自定义bean工厂
 * @author: lij
 * @create: 2019-09-14 21:54
 */
public class MyFactoryBean implements FactoryBean<Monkey> {
    @Override
    public Monkey getObject() throws Exception {
        return new Monkey();
    }

    @Override
    public Class<Monkey> getObjectType() {
        return Monkey.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
