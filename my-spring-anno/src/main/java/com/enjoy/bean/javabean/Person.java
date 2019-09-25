package com.enjoy.bean.javabean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 人
 * @author: lij
 * @create: 2019-09-14 00:02
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
