package com.enjoy._value;

import com.enjoy._value.javabean.Bird2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.DefaultPropertySourceFactory;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;
import org.springframework.core.io.support.ResourcePropertySource;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
 * @description: 自定义Property读取
 * @author: lij
 * @create: 2019-09-16 16:02
 */
public class MyPropertySourceFactory extends DefaultPropertySourceFactory {

    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException {
        String sourceName = name != null ? name : resource.getResource().getFilename();
        if (sourceName.endsWith(".yml") || sourceName.endsWith(".yaml")){
            Properties propertiesFromYaml = loadYml(resource);
            return new PropertiesPropertySource(sourceName, propertiesFromYaml);
        }else{
            return super.createPropertySource(name, resource);
        }
    }

    private Properties loadYml(EncodedResource resource) throws IOException {
        YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();
        factory.setResources(resource.getResource());
        factory.afterPropertiesSet();
        return factory.getObject();
    }
}
