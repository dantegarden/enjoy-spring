package com.dg.service.impl;

import com.dg.annotation.DgService;
import com.dg.service.MyService;

/**
 * @description:
 * @author: lij
 * @create: 2019-09-25 12:05
 */
@DgService("myService")
public class MyServiceImpl implements MyService {
    @Override
    public String query(String name, String age) {
        return "name ==" + name + " age ==" + age;
    }

    @Override
    public String insert(String param) {
        return "insert succefully";
    }

    @Override
    public String update(String param) {
        return "update succefully";
    }
}
