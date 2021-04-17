package com.example.designpattern.decorator.shape;

/**
 * @Author cph
 * @Date 2020/3/14
 */
public class DecoratorPatternDemo {
    public static void main(String[] args) {

        /*
         * 适用场景：在不改变原有类结构的情况下，扩展一个类的功能
         * 设计思想：存在 业务类接口 及 具体的业务实现类，
         *          新建 装饰器抽象类 实现 业务类接口，
         *          新建 装饰器实现类 继承 装饰器抽象类，
         *          在 装饰器实现类 中具体实现扩展功能
         * 使用方法：新建 装饰器抽象类 实现 业务类接口，
         *          新建 装饰器实现类 继承 装饰器抽象类，
         *          在 装饰器实现类 中具体实现扩展功能
         */

        Shape circle = new Circle();

        Shape redCircle = new RedShapeDecorator(new Circle());
        Shape redRectangle = new RedShapeDecorator(new Rectangle());

        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nCircle of red border");
        redCircle.draw();

        System.out.println("\nRectangle of red border");
        redRectangle.draw();
    }
}
