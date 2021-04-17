package com.example.designpattern.strategy.pay.payport;

import com.example.designpattern.strategy.pay.MsgResult;

/**
 * @author cph
 * @date 2019/7/20
 */
public abstract class Payment {

    public abstract String getName();

    protected abstract double queryBalance(String uid);

    public MsgResult pay(String uid, double amount) {
        if (queryBalance(uid) < amount) {
            return new MsgResult(500, "支付失败", "账户余额不足，余额为：" + queryBalance(uid));
        }
        return new MsgResult(200, "支付成功", "支付金额：" + amount);
    }


}
