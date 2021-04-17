package com.example.designpattern.proxy.staticproxy.datasource;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author cph
 * @Date 2020/1/30
 */
public class Test {
    public static void main(String[] args) {
        try {
            Order order = new Order();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date date = sdf.parse("2019/01/01");
            order.setCreateTime(date.getTime());
            IOrderService orderService = new OrderServiceStaticProxy(new OrderService());
            orderService.createOrder(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
