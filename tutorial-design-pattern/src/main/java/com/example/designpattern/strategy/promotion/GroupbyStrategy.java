package com.example.designpattern.strategy.promotion;

/**
 * @author cph
 * @date 2019/7/19
 */
public class GroupbyStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("组团就是干");
    }
}
