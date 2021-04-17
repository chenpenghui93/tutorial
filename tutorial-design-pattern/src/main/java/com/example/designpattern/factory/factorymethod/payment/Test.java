package com.example.designpattern.factory.factorymethod.payment;

/**
 * @author chenpenghui
 * @date 2021-3-17
 */
public class Test {
    public static void main(String[] args) {
        PaymentFactory crossBorderPayFactory = new CrossBorderPayFactory();
        crossBorderPayFactory.payMethod().pay();

        WechatPayFactory wechatPayFactory = new WechatPayFactory();
        wechatPayFactory.payMethod().pay();

        AliPayFactory aliPayFactory = new AliPayFactory();
        aliPayFactory.payMethod().pay();

        UnionPayFactory unionPayFactory = new UnionPayFactory();
        unionPayFactory.payMethod().pay();
    }
}
