package com.example.designpattern.strategy.promotion;

/**
 * @author cph
 * @date 2019/7/19
 */
public class CashbackStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("任性，直接返现");
    }
}
