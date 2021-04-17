package com.example.algorithm.sorting.bubble;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author chenpenghui
 * @date 2020-9-5
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array1 = new int[]{3, 2, 44, 37, 25, 66, 99, 27, 49};
        System.out.println("before: " + Arrays.toString(array1));
        System.out.println("after1: " + Arrays.toString(bubbleSort1(array1)));

        int[] array2 = new int[]{3, 2, 44, 37, 100, 66, 99, 27, 49};
        System.out.println("before: " + Arrays.toString(array2));
        System.out.println("after2: " + Arrays.toString(bubbleSort2(array2)));
    }

    public static int[] bubbleSort1(int[] array) {
        // 临时变量
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }

            }
        }
        return array;
    }

    public static int[] bubbleSort2(int[] array) {
        // 临时变量
        int temp;
        // 交换标记
        boolean flag;
        for (int i = 0; i < array.length - 1; i++) {
            flag = false;
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
                flag = true;

            }
            if (!flag) {
                break;
            }
        }
        return array;
    }
}
