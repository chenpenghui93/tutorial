package com.example.designpattern.strategy.promotion;

/**
 * @author cph
 * @date 2019/7/19
 */
public class PromotionActivity {

    PromotionStrategy promotionStrategy;

    public PromotionActivity(PromotionStrategy promotionStrategy) {
        this.promotionStrategy = promotionStrategy;
    }

    public void execute() {
        this.promotionStrategy.doPromotion();
    }
}
