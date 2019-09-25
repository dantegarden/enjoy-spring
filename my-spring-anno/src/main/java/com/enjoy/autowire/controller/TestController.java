package com.enjoy.autowire.controller;

import com.enjoy.autowire.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @description:
 * @author: lij
 * @create: 2019-09-16 16:20
 */
@Controller
public class TestController {
    @Autowired
    private TestService testService;
}
