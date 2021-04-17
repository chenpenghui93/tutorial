package com.example.designpattern.prototype.shallow;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cph
 * @Date 2019/12/28
 */
public class ProtoTypeTest {
    public static void main(String[] args) {
        //需要克隆的对象
        ConcreteProtoTypeA concreteProtoType = new ConcreteProtoTypeA();
        concreteProtoType.setName("protoType");
        concreteProtoType.setAge(30);
        List<String> hobbies = new ArrayList<>();
        concreteProtoType.setHobbies(hobbies);
        System.out.println(concreteProtoType);

        //模拟客户端调用
        Client client = new Client();
        ConcreteProtoTypeA concreteProtoTypeClone = (ConcreteProtoTypeA) client.startClone(concreteProtoType);
        System.out.println(concreteProtoTypeClone);

        //从结果可看出，引用地址相同，复制的是引用的地址，而不是值
        System.out.println("原对象中引用类型地址： " + concreteProtoType.getHobbies());
        System.out.println("克隆对象中引用类型地址： " + concreteProtoTypeClone.getHobbies());
        System.out.println("对象地址比较: " + (concreteProtoType.getHobbies() == concreteProtoTypeClone.getHobbies()));

    }
}
