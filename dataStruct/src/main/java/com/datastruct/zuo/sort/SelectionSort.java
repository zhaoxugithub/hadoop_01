package com.datastruct.zuo.sort;

import com.datastruct.zuo.common.ArrayUtils;

public class SelectionSort {


    /*

        算法思想：
            1.在0 ~ n-1 上不断的找最小数然后依次放到指定位置上
     */
    public static void sort(int[] arr) {
        // 在 0 ~ n-1 上遍历
        for (int i = 0; i < arr.length - 1; i++) {

            //这个循环是在i+1 ~ n-1 上找最小元素，找到的话，放到i位置上
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    ArrayUtils.swap(arr, i, j);
                }
            }
        }
    }

    public static void sort2(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    ArrayUtils.swap(arr, i, j);
                }
            }
        }
    }

    public static void sort3(int[] arr) {
        for (int i = 0; i < arr.length; i++) {

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    ArrayUtils.swap(arr, i, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = ArrayUtils.generateRandomArray(10, 30, 0);
        ArrayUtils.printArr(ints);
        sort3(ints);
        ArrayUtils.printArr(ints);
    }
}
