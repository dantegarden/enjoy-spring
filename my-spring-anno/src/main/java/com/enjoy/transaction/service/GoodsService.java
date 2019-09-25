package com.enjoy.transaction.service;

import com.enjoy.transaction.dao.GoodsDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:
 * @author: lij
 * @create: 2019-09-20 14:47
 */
@Service
@Slf4j
public class GoodsService {
    @Autowired
    private GoodsDao goodsDao;

    @Transactional
    public void addGoods(){
        goodsDao.insert();
        log.info("操作完成");
        int i = 1/0;
    }
}
