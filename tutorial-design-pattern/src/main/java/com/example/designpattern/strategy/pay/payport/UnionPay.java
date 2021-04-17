package com.example.designpattern.strategy.pay.payport;

/**
 * @author cph
 * @date 2019/7/20
 */
public class UnionPay extends Payment {
    @Override
    public String getName() {
        return "银联支付";
    }

    @Override
    protected double queryBalance(String uid) {
        return 100.0;
    }
}
