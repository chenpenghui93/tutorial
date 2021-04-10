package com.example.javabasic.sample.exception.example2;

/**
 * 输出结果：
 * Caught Annoyance
 * Caught Sneeze
 * Hello World!
 *
 * finally语句会在return之前执行
 *
 * @author chenpenghui
 * @date 2021-4-4
 */
public class Human {
    public static void main(String[] args) throws Exception {

        try {
            try {
                throw new Sneeze();
            } catch (Annoyance a) {
                System.out.println("Caught Annoyance");
                throw a;
            }
        } catch (Sneeze s) {
            System.out.println("Caught Sneeze");
            return;
        } finally {
            System.out.println("Hello World!");
        }
    }
}
