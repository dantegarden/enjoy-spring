package com.enjoy._import.config;

import com.enjoy._import.factory.MyFactoryBean;
import com.enjoy._import.javabean.Cat;
import com.enjoy._import.javabean.Dog;
import com.enjoy._import.register.MyBeanRegister;
import com.enjoy._import.selector.AnimalImportSelector;
import com.enjoy.bean.javabean.Person;
import com.enjoy.conditional.config.MainConfig5;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @description: import配置类
 * @author: lij
 * @create: 2019-09-14 20:57
 */
@Slf4j
@Configuration
//@Import(value = {Dog.class, Cat.class})
//@Import(value = {MainConfig5.class})  //也可以导入其他configuration
//@Import(value = {Dog.class, Cat.class, AnimalImportSelector.class})
@Import(value = {Dog.class, Cat.class, MyBeanRegister.class})
public class MainConfig6 {

    /**
     * 给容器中注册组件的方式
     * 1 @Bean 导入第三方的类或包的组件，比如Person是第三方类，需要注册到我们的IOC中
     * 2 @ComponetScan + @Component/@Controller/@Service/@Repository 一般是扫我们自己写的类
     * 3 @Import 快速向IOC容器里注册组件
     *   3,1 @Imort(类的class) 容器会自动注册这个组件，bean的id默认为类的全限定名
     *   3.2 实现ImportSelector接口，实现selectImports方法，返回需要注册进IOC容器的类的全限定名数组
     *   3.3 实现ImportBeanDefinitionRegister接口，实现registerBeanDefinitions方法，调用registry.registerBeanDefinition方法注册
     * 4 实现FactoryBean接口
     * **/
    @Bean
    public Person person(){
        log.info("向容器中添加person对象");
        return new Person();
    }

    @Bean
    public MyFactoryBean myFactoryBean(){
        return new MyFactoryBean();
    }

}
