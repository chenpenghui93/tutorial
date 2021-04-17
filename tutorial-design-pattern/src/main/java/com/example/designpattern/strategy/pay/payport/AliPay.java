package com.example.designpattern.strategy.pay.payport;

/**
 * @author cph
 * @date 2019/7/20
 */
public class AliPay extends Payment {
    @Override
    public String getName() {
        return "支付宝";
    }

    @Override
    protected double queryBalance(String uid) {
        return 1000.0;
    }
}
