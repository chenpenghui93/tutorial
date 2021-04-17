package com.example.designpattern.strategy.promotion;

/**
 * @author cph
 * @date 2019/7/19
 */
public class CouponStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("优惠券——满5000减500");
    }
}
