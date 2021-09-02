package com.example.javabasic.sample.exception.multilevel;

/**
 * @author: cph
 * @date: 2021/9/2 14:34
 */
public class TryCatchFinally {
    public static void main(String[] args) {
        int result;
        try {
            System.out.println("in level1");
            // result = 100 / 0;

            try {
                System.out.println("in level2");
                // result = 100 / 0;

                try {
                    System.out.println("in level3");
                    result = 100 / 0;
                } catch (Exception e) {
                    System.out.println("level3 " + e.getClass().toString());
                } finally {
                    System.out.println("in level3 finally");
                }

            } catch (Exception e) {
                System.out.println("level2 " + e.getClass().toString());
            } finally {
                System.out.println("in level2 finally");
            }

        } catch (Exception e) {
            System.out.println("level1 " + e.getClass().toString());
        } finally {

            // 执行此语句后，执行立即结束，后续代码不再执行
            //System.exit(0);

            System.out.println("in level1 finally");
        }
    }
}
