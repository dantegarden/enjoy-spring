package com.enjoy.componentScan.annotationFilter;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;
import java.util.Random;

/**
 * @description: 自定义注解筛选器
 * @author: lij
 * @create: 2019-09-14 16:48
 */
public class MyTypeFilter implements TypeFilter{
    /**
     * metadataReader 读取到当前正在扫描的类信息
     * metadataReaderFactory 可通过factory获取到任何类的信息
     * @return 是否扫描进去，布尔值
     * **/
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //获取当前正在扫描的类的注解
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //获取当前正在扫描的类的信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //当前扫描到的类的路径
        Resource resource = metadataReader.getResource();

        System.out.println("----> " + classMetadata.getClassName());

        return new Random().nextBoolean();
    }
}
