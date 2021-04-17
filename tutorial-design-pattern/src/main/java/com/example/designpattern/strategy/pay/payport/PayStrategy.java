package com.example.designpattern.strategy.pay.payport;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cph
 * @date 2019/7/20
 */
public class PayStrategy {

    public static final String ALI_PAY = "ALI_PAY";
    public static final String WECHAT_PAY = "WECHAT_PAY";
    public static final String JD_PAY = "JD_PAY";
    public static final String UNION_PAY = "UNION_PAY";
    private static final String DEFAULT_PAY = ALI_PAY;

    private static Map<String, Payment> payStrategy = new HashMap<>();

    static {
        payStrategy.put(ALI_PAY, new AliPay());
        payStrategy.put(WECHAT_PAY, new WechatPay());
        payStrategy.put(JD_PAY, new JDPay());
        payStrategy.put(UNION_PAY, new UnionPay());
    }

    //通过统一入口实现动态支付策略
    public static Payment get(String payKey) {
        if (!payStrategy.containsKey(payKey)) {
            return payStrategy.get(DEFAULT_PAY);
        }
        return payStrategy.get(payKey);

    }
}
