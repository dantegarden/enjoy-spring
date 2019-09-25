package com.enjoy.mvc.controller;

import com.enjoy.mvc.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description:
 * @author: lij
 * @create: 2019-09-23 20:47
 */
@Controller
@RequestMapping("/aa")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/buy")
    @ResponseBody
    public String buy(){
        log.info(Thread.currentThread().getName() + "doGet");
        String result = orderService.goBuy("1");
        return "buy successfully " + result;
    }

    @RequestMapping("/ceshi")
    public String toCeshi(){
        return "ceshi";
    }
}
