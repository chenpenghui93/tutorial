package com.example.designpattern.factory.factorymethod.payment;

/**
 * @author chenpenghui
 * @date 2021-3-17
 */
public class AliPay implements IPayment {
    @Override
    public void pay() {
        System.out.println("阿里支付");
    }
}
