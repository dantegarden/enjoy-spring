package com.enjoy._import.selector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @description: 通过全限定名引入bean的选择器
 * @author: lij
 * @create: 2019-09-14 21:30
 */
public class AnimalImportSelector implements ImportSelector {
    /**
     * @param importingClassMetadata
     * @return: java.lang.String[]  要导入ioc容器的类的全限定名数组，有重复只会导入一次
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.enjoy._import.javabean.Bird"};
    }
}
