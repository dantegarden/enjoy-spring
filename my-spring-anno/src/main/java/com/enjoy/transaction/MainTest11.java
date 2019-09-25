package com.enjoy.transaction;

import com.enjoy.transaction.config.MainConfig11;
import com.enjoy.transaction.service.GoodsService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @description: 事务测试
 * @author: lij
 * @create: 2019-09-14 17:42
 */
public class MainTest11 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig11.class);
        System.out.println("IOC容器创建完成");

        GoodsService goodsService = context.getBean(GoodsService.class);
        goodsService.addGoods();


        context.close();
        System.out.println("IOC容器已销毁");
    }
}
