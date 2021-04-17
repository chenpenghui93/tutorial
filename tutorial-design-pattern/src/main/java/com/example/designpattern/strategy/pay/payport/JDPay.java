package com.example.designpattern.strategy.pay.payport;

/**
 * @author cph
 * @date 2019/7/20
 */
public class JDPay extends Payment {
    @Override
    public String getName() {
        return "京东支付";
    }

    @Override
    protected double queryBalance(String uid) {
        return 800.0;
    }
}
