package com.example.designpattern.factory.factorymethod.payment;

/**
 * @author chenpenghui
 * @date 2021-3-17
 */
public class CrossBorderPay implements IPayment {
    @Override
    public void pay() {
        System.out.println("跨境支付");
    }
}
