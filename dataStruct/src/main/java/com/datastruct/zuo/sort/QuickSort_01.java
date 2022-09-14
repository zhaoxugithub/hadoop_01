package com.datastruct.zuo.sort;


import static com.datastruct.zuo.common.ArrayUtils.generateRandomArray;
import static com.datastruct.zuo.common.ArrayUtils.printArr;

/**
 * 快排1.0
 * 特点：  L  > R
 * partition  sort sort
 * arr  l  r
 */
public class QuickSort_01 {

    public static void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[] arr, int L, int R) {
        if (L > R) {
            return;
        }
        int m = partition(arr, L, R);
        sort(arr, L, m - 1);
        sort(arr, m + 1, R);
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static int partition(int[] arr, int L, int R) {
        int index = L;
        int less = L - 1;
        int more = R + 1;
        int num = arr[R];
        while (index < more) {

            if (arr[index] <= num) {
                swap(arr, index, ++less);
            }
            index++;
        }
        return less;
    }

    public static int partition2(int[] arr, int L, int R) {
        int index = L;
        int less = L - 1;
        int more = R + 1;
        int num = arr[R];
        while (index < more) {

            if (arr[index] < num) {
                swap(arr, index++, ++less);
            }
            index++;
        }
        return less;
    }


    public static void main(String[] args) {

        int[] array = generateRandomArray(10, 10, 0);
        printArr(array);
        sort(array);
        printArr(array);
    }

}
