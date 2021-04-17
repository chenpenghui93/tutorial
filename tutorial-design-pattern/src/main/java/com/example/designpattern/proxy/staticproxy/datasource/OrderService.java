package com.example.designpattern.proxy.staticproxy.datasource;

/**
 * @Author cph
 * @Date 2020/1/30
 */
public class OrderService implements IOrderService {
    private OrderDao orderDao;

    public OrderService() {
        //为方便使用直接创建
        orderDao = new OrderDao();
    }

    @Override
    public int createOrder(Order order) {
        System.out.println("OrderService调用OrderDao创建订单！");
        return orderDao.insertOrder(order);
    }
}
