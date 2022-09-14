package com.datastruct.zuo.sort;

import com.datastruct.zuo.common.ArrayUtils;

/*
    插入排序： 首先保证在0 ~0 上有序
                     0 ~ 1 上有序
                     0 -2 上有序
                     ...
                     0 ~ n-1
                     0 ~ n 上有序
        依次往左看
 */
public class InsertSort {
    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                if (arr[j] > arr[j + 1]) {
                    ArrayUtils.swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void sort2(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                ArrayUtils.swap(arr, j, j + 1);
            }
        }
    }

    public static void sort3(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int index = i - 1;
            while (index >= 0) {
                if (arr[index] > arr[index + 1]) {
                    ArrayUtils.swap(arr, index, index + 1);
                } else {
                    index--;
                }
            }
        }
    }

    public static void sort4(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            while (j >= 0 && arr[j + 1] < arr[j]) {
                ArrayUtils.swap(arr, j, j + 1);
                j--;
            }
        }
    }

    public static void sort5(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            while (j >= 0) {
                if (arr[j] > arr[j + 1]) {
                    ArrayUtils.swap(arr, j, j + 1);
                }
                j--;
            }
        }
    }


    public static void sort6(int[] array) {

        if (array == null || array.length == 1) return;

        for (int i = 1; i < array.length; i++) {

            int j = i - 1;
            while (j >= 0) {
                if (array[j] > array[j + 1]) {
                    ArrayUtils.swap(array, j, j + 1);
                }
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = ArrayUtils.generateRandomArray(10, 40, 0);
        ArrayUtils.printArr(ints);
        sort6(ints);
        ArrayUtils.printArr(ints);

        System.out.println("-----------------------");



    }
}
