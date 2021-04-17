package com.example.designpattern.strategy.promotion;

/**
 * @author cph
 * @date 2019/7/19
 */
public class PromotionActivityTest {
//    直接调用
//    public static void main(String[] args) {
//        PromotionActivity activity1 = new PromotionActivity(new EmptyStrategy());
//        PromotionActivity activity2 = new PromotionActivity(new CashbackStrategy());
//        activity1.execute();
//        activity2.execute();
//    }

//    优化1
//    public static void main(String[] args) {
//        PromotionActivity promotionActivity = null;
//        String promotion = "cash";
//
//        if (isEquals(promotion, "empty")) {
//            promotionActivity = new PromotionActivity(new EmptyStrategy());
//            promotionActivity.execute();
//        } else if (isEquals(promotion, "cash")) {
//            promotionActivity = new PromotionActivity(new CashbackStrategy());
//            promotionActivity.execute();
//        }
//    }
//
//    private static boolean isEquals(String source, String target) {
//        if (source.equals(target)) {
//            return true;
//        }else {
//            return false;
//        }
//    }

    //    优化2
    public static void main(String[] args) {
        String promotionKey = "CASH";
        PromotionActivity promotionActivity = new PromotionActivity(PromotionStrategyFactory.getPromotionStrategy(promotionKey));
        promotionActivity.execute();
    }

}
