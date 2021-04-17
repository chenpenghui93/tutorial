package com.example.designpattern.proxy.cglibproxy;

import org.springframework.cglib.core.DebuggingClassWriter;

/**
 * 调用过程
 * 1、代 理 对 象 调 用 this.findLove() 方 法
 * 2、调 用 拦 截 器
 * 3、methodProxy.invokeSuper
 * 4、CGLIB$findLove$0
 * 5、被代理对象 findLove()方法
 * <p>
 * CGLib 动态代理执行代理方法效率之所以比 JDK 的高是因为Cglib 采用了 FastClass 机制，
 * 它的原理简单来说就是：为代理类和被代理类各生成一个 Class，这个 Class 会为代
 * 理类或被代理类的方法分配一个 index(int 类型)。这个 index 当做一个入参，FastClass
 * 就可以直接定位要调用的方法直接进行调用，这样省去了反射调用，所以调用效率比 JDK
 * 动态代理通过反射调用高
 *
 * @Author cph
 * @Date 2020/1/31
 */
public class CglibTest {
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,
                "D://cglib_proxy_class/");

        // CGLib代理的目标对象不需要实现任何接口，它是通过动态继承目标对象实现的动态代理
        Customer c = (Customer) new CglibMeipo().getInstance(Customer.class);
        c.findLove();
    }
}
