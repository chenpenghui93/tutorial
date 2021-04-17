package com.example.designpattern.prototype.deep;

/**
 * @Author cph
 * @Date 2019/12/28
 */
public class DeepCloneTest {
    public static void main(String[] args) {
        //原型对象
        MonkeyKing monkeyKing = new MonkeyKing();
        try {
            //深拷贝对象
            MonkeyKing deepClone = (MonkeyKing) monkeyKing.clone();
            System.out.println("深拷贝：" + (deepClone.stick == monkeyKing.stick));
        } catch (Exception e) {
            e.printStackTrace();
        }

        MonkeyKing monkeyKing1 = new MonkeyKing();
        //浅拷贝
        MonkeyKing shallowClone = monkeyKing1.shallowClone(monkeyKing1);
        System.out.println("浅拷贝：" + (shallowClone.stick == monkeyKing1.stick));
    }
}
