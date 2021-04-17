package com.example.designpattern.factory.factorymethod.payment;

/**
 * @author chenpenghui
 * @date 2021-3-17
 */
public class CrossBorderPayFactory implements PaymentFactory {

    @Override
    public IPayment payMethod() {
        return new CrossBorderPay();
    }
}
