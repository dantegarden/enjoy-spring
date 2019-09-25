package com.enjoy.transaction.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author: lij
 * @create: 2019-09-20 14:41
 */
@Repository
public class GoodsDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(){
        String sql = "insert into `tb_goods` (goods_name, goods_title, goods_img, goods_detail, goods_price, goods_stock) values(?,?,?,?,?,?)";
        jdbcTemplate.update(sql, "一加7pro", "一加7pro", "img/oneplus.png", "一加7pro 128GB", 5000, 1000);
    }
}
