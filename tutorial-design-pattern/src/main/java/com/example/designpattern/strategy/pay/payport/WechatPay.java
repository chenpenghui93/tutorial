package com.example.designpattern.strategy.pay.payport;

/**
 * @author cph
 * @date 2019/7/20
 */
public class WechatPay extends Payment {
    @Override
    public String getName() {
        return "微信支付";
    }

    @Override
    protected double queryBalance(String uid) {
        return 500.0;
    }
}
