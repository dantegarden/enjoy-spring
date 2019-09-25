package com.enjoy.autowire.service;

import com.enjoy.autowire.dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * @description:
 * @author: lij
 * @create: 2019-09-16 16:20
 */
@Service
public class TestService {
    //@Qualifier("testDao2")
    //@Autowired
//    @Resource
    @Named("testDao2")
    @Inject
    private TestDao testDao;

    public void test(){
        System.out.println(testDao + "  "+ testDao.getFlag());
    }
}
