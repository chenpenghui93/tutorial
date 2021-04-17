package com.example.javabasic.sample.equals;

import java.util.List;
import java.util.Objects;

/**
 * 重写equals()、hashcode()
 *
 * @author chenpenghui
 * @date 2020-9-20
 */
public class Student {

    private Long id;
    private String name;
    private String sex;
    private int age;
    private List<Integer> score;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Integer> getScore() {
        return score;
    }

    public void setScore(List<Integer> score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    @Override
    public boolean equals(Object otherObject) {
        // 1.显示参数命名为otherObject，稍后转换成另一个other的变量
        // 2.检测this与otherObject是否引用同一个对象
        if (this == otherObject) {
            return true;
        }
        // 3.检测otherObject是否为null，如果为null则返回false
        // 4.比较this与otherObject是否属于同一个类
        // 如果equals的语义在每个子类中有所改变，就使用getClass检测
        // 如果所有的子类都拥有统一的语义就使用instanceof检测 if(!(otherObject instanceof ClassName)) return false
        if (otherObject == null || getClass() != otherObject.getClass()) {
            return false;
        }
        // 5.将otherObject转换为相应的类类型变量
        Student other = (Student) otherObject;
        // 6.开始对所有需要比较的域进行比较：使用 == 比较基本类型域，使用equals比较对象域
        // 如果是在子类中重新定义equals，需要在其中包含调用super.equals(other)
        return age == other.age &&
                Objects.equals(id, other.id) &&
                Objects.equals(name, other.name) &&
                Objects.equals(sex, other.sex) &&
                Objects.equals(score, other.score);
    }

    @Override
    public int hashCode() {
        // 调用Objects.hash()，数组类型可调用Arrays.hashCode()
        return Objects.hash(id, name, sex, age, score);
    }
}
