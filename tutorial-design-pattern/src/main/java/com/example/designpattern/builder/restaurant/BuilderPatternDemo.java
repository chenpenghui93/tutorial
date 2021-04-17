package com.example.designpattern.builder.restaurant;

/**
 * @Author cph
 * @Date 2020/4/12
 */
public class BuilderPatternDemo {
    public static void main(String[] args) {

        /**
         * 适用场景： 创建复杂对象并且可预见对象内容会变更
         * 设计思想：
         * 使用方法：
         */
        MealBuilder mealBuilder = new MealBuilder();
        Meal vegMeal = mealBuilder.prepareVegBurger();
        System.out.println("Veg Meal");
        vegMeal.showItems();
        System.out.println("total cost: " + vegMeal.getCost());

        Meal nonVegMeal = mealBuilder.prepareNonVegBurger();
        System.out.println("\n\nNon-Veg Meal");
        nonVegMeal.showItems();
        System.out.println("total cost: " + nonVegMeal.getCost());
    }
}
