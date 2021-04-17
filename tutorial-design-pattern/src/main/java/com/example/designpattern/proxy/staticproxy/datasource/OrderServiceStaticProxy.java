package com.example.designpattern.proxy.staticproxy.datasource;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author cph
 * @Date 2020/1/30
 */
public class OrderServiceStaticProxy implements IOrderService {

    private SimpleDateFormat format = new SimpleDateFormat("yyyy");

    private IOrderService orderService;

    public OrderServiceStaticProxy(IOrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public int createOrder(Order order) {
        before();
        Long time = order.getCreateTime();
        Integer dbRouter = Integer.valueOf(format.format(new Date(time)));
        System.out.println("静态代理类自动分配到【DB_" + dbRouter + "】数据源处理数据");
        DynamicDataSourceEntity.set(dbRouter);
        orderService.createOrder(order);
        after();
        return 0;
    }

    private void before() {
        System.out.println("proxy method before");
    }

    private void after() {
        System.out.println("proxy method after");
    }
}
