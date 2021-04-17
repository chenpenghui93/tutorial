package com.example.designpattern.prototype.shallow;

import java.util.List;

/**
 * @Author cph
 * @Date 2019/12/28
 */
public class ConcreteProtoTypeA implements ProtoType {

    private String name;
    private int age;
    private List<String> hobbies;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public ProtoType clone() {
        ConcreteProtoTypeA concreteProtoType = new ConcreteProtoTypeA();
        concreteProtoType.setName(this.name);
        concreteProtoType.setAge(this.age);
        concreteProtoType.setHobbies(this.hobbies);
        return concreteProtoType;
    }

}
