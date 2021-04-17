package com.example.designpattern.proxy.staticproxy.datasource;

/**
 * @Author cph
 * @Date 2020/1/30
 */
public class OrderDao {
    public int insertOrder(Order order) {
        System.out.println("OrderDao创建Order成功！");
        return 1;
    }
}
