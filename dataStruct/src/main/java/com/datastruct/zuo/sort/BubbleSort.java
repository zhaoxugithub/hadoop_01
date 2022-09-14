package com.datastruct.zuo.sort;

import com.datastruct.zuo.common.ArrayUtils;

public class BubbleSort {

    public static void main(String[] args) {
        int[] ints = ArrayUtils.generateRandomArray(10, 30, 0);
        ArrayUtils.printArr(ints);
        sort3(ints);
        ArrayUtils.printArr(ints);
    }

    /*
        算法想法：在0 ~ n-1 之间 两两比较谁大谁小，大的往后面，交换n-1次之后肯定可以找到最大的放在最后面
                第二次在 0~n-2 之间两两之间比较大小。。。
     */
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    ArrayUtils.swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void sort2(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    ArrayUtils.swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void sort3(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    ArrayUtils.swap(arr, j, j + 1);
                }
            }
        }
    }

}
