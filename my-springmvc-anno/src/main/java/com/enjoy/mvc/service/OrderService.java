package com.enjoy.mvc.service;

import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: lij
 * @create: 2019-09-23 20:49
 */
@Service
public class OrderService {

    public String goBuy(String orderId){
        return "orderId ===" + orderId;
    }
}
