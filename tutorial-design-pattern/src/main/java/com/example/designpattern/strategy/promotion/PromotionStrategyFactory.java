package com.example.designpattern.strategy.promotion;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cph
 * @date 2019/7/20
 */
public class PromotionStrategyFactory {

    private static final PromotionStrategy NON_PROMOTION = new EmptyStrategy();
    private static Map<String, PromotionStrategy> PROMOTION_STRATEGY_MAP = new HashMap<>();

    static {
        PROMOTION_STRATEGY_MAP.put(PromotionKey.CASH, new CashbackStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionKey.COUPON, new CouponStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionKey.GROUPBY, new GroupbyStrategy());
    }

    private PromotionStrategyFactory() {
    }

    public static PromotionStrategy getPromotionStrategy(String promotionKey) {
        PromotionStrategy promotionStrategy = PROMOTION_STRATEGY_MAP.get(promotionKey);
        return promotionStrategy == null ? NON_PROMOTION : promotionStrategy;
    }

    private interface PromotionKey {
        String CASH = "CASH";
        String COUPON = "COUPON";
        String GROUPBY = "GROUPBY";
    }
}
