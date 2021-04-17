package com.example.designpattern.factory.factorymethod.payment;

/**
 * @author chenpenghui
 * @date 2021-3-17
 */
public class UnionPayFactory implements PaymentFactory {
    @Override
    public IPayment payMethod() {
        return new UnionPay();
    }
}
