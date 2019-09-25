package com.enjoy._value.javabean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

/**
 * @description: 鸟
 * @author: lij
 * @create: 2019-09-16 15:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bird {
    //使用@Value赋值，1.基本字符，2.springEL表达式 3.环境变量
    @Value("mybird")
    private String name;
    @Value("#{20-2}")
    private Integer age;
    @Value("${bird.color}")
    private String color;
    @Value("${bird.color2}")
    private String color2;

    @Override
    public String toString() {
        return "Bird{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                ", color2='" + color2 + '\'' +
                '}';
    }
}
