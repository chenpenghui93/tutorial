package com.example.designpattern.strategy.pay;

import com.example.designpattern.strategy.pay.payport.PayStrategy;

/**
 * @author cph
 * @date 2019/7/20
 */
public class PayStrategyTest {
    public static void main(String[] args) {
        Order order = new Order("1", "2019072000001", 400);
        MsgResult msgResult = order.pay(PayStrategy.UNION_PAY);
        System.out.println(msgResult);
    }
}
