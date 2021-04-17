package com.example.javabasic.sample.generic;

/**
 * 为什么使用泛型？
 * 1.代码重用：写一次 类/方法/接口，在多种类型中使用
 * 2.类型安全：泛型可以让错误提前至编译时而不是运行时被发现
 *
 * @Author cph
 * @Date 2020/1/19
 */
public class GenericTest {
    public static void main(String[] args) {
        //Integer·
        Test1<Integer> iObj = new Test1<>(15);
        System.out.println(iObj.getObject());

        //String
        Test1<String> sObj = new Test1<>("GeeksForGeeks");
        System.out.println(sObj.getObject());

        Test2<String, Integer> obj = new Test2<>("hi", 666);
        obj.print();

        genericDisplay(11);
        genericDisplay("GeeksForGeeks");
        genericDisplay(1.0);
    }

    /**
     * 泛型类(一个参数)
     *
     * @param <T>
     */
    static class Test1<T> {
        //声明类型为T的对象
        T obj;

        public T getObject() {
            return this.obj;
        }

        //构造函数
        Test1(T obj) {
            this.obj = obj;
        }
    }

    /**
     * 泛型类(多个参数)
     *
     * @param <T>
     * @param <U>
     */
    static class Test2<T, U> {
        T obj1;
        U obj2;

        public Test2(T obj1, U obj2) {
            this.obj1 = obj1;
            this.obj2 = obj2;
        }

        public void print() {
            System.out.println(obj1);
            System.out.println(obj2);
        }
    }

    /**
     * 泛型方法
     *
     * @param element
     * @param <T>
     */
    public static <T> void genericDisplay(T element) {
        System.out.println(element.getClass().getName() + " = " + element);
    }
}
