package com.example.javabasic.sample.serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 序列化是处理对象流的一种机制
 * 对象流就是将对象的内容进行流化，可以对流化后的对象进行读写操作，也可以将流化后的对象在网络间传输
 * 通过序列化解决对象流进行读写操作时可能引发的问题，例如，数据乱序
 * 还可以用于对象的深度克隆
 *
 * 序列化就是按照约定的规范、格式将对象内容从运行的程序A中写到文件里
 * 反序列化就是按照约定的规范、格式将对象内容从文件里读到运行的程序B中
 *
 * @author chenpenghui
 * @date 2021-4-28
 */
public class Person implements Serializable {

    /**
     * 解决序列化版本问题，防止java.io.InvalidClassException
     * <p>
     * 在完成序列化操作后，由于项目升级或修改，会对序列化对象进行修改(比如增加某个字段)，
     * 如果不使用serialVersionUID，进行反序列化时就会报错
     */
    private static final long serialVersionUID = 2072016335317329680L;

    private String name;

    /**
     * 如果某些数据不需要序列化，可以在字段前面加上关键字transient
     */
    transient private Integer age;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) throws Exception {

        // 构造数据
        List<Person> personList = new ArrayList<>();
        for (int i=0; i<5; i++) {
            Person person = new Person();
            person.setName("name" + i);
            person.setAge(i);
            personList.add(person);
        }

        // 如果不实现Serializable接口，则在写对象时会抛出java.io.NotSerializableException
        // 使用ObjectOutputStream实现对象序列化
        FileOutputStream op = new FileOutputStream(File.separator + "a.txt");
        ObjectOutputStream ops = new ObjectOutputStream(op);
        ops.writeObject(personList);
        ops.close();

        // 使用ObjectInputStream实现对象反序列化
        InputStream is = new FileInputStream(File.separator + "a.txt");
        ObjectInputStream ois = new ObjectInputStream(is);
        List<Person> personList1 = (List<Person>) ois.readObject();
        System.out.println(personList1);
        ois.close();

    }
}
