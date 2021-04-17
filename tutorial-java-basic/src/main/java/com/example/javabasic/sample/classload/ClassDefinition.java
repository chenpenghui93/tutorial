package com.example.javabasic.sample.classload;

/**
 * 成员变量(字段)：作用范围为整个类，定义在方法体和语句块之外，一般定义在类声明之下；成员变量包括实例变量、类变量(静态变量)、常量
 * 局部变量：作用范围为定义的方法体或语句块内部
 * 实例变量：不用static修饰的成员变量，随对象的创建而创建；每个对象都有自己独有的实例变量，属于对象私有，调用需要实例化对象
 * 静态变量：用static修饰的成员变量，又称类变量，一个类中只有一份，属于对象共有
 * 常量：用static final修饰的成员变量，在类中只有一份，同时不能修改它的值
 *
 * @Author cph
 * @Date 2020/1/17
 */
public class ClassDefinition {

    /**
     * 成员变量、实例变量
     */
    private Long id;

    /**
     * 成员变量、实例变量
     */
    private String name;

    /**
     * 成员变量、实例变量
     */
    private Integer score;

    /**
     * 成员变量、类变量(静态变量)
     */
    public static String level = "primary";

    /**
     * 成员变量、常量
     */
    public static final String mood = "happy";

    /**
     * id的可读属性
     *
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     * id的可写属性
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * 默认无参构造函数
     */
    public ClassDefinition() {

    }

    /**
     * 带参构造函数
     *
     * @param id
     * @param name
     * @param score
     */
    public ClassDefinition(Long id, String name, Integer score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    /**
     * 普通方法
     */
    public void study() {
        //study为局部变量
        String study = "learning";
    }
}

