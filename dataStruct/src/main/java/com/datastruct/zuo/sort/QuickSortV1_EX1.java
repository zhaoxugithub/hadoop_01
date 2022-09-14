package com.datastruct.zuo.sort;

import com.datastruct.zuo.common.ArrayUtils;

/**
 * 快速排序复习
 */
public class QuickSortV1_EX1 {


    public static void main(String[] args) {
        int[] randomArray = ArrayUtils.generateRandomArray(10, 100, 2);
        ArrayUtils.printArr(randomArray);
        sort(randomArray);
        ArrayUtils.printArr(randomArray);
    }


    public static void sort(int[] array) {

        if (array == null || array.length == 1) return;
        sort(array, 0, array.length - 1);

    }

    public static void sort(int[] array, int l, int r) {
        if (l >= r) return;
        int mid = partition(array, l, r);
        sort(array, l, mid - 1);
        sort(array, mid + 1, r);
    }

    public static int partition(int[] array, int l, int r) {
        int index = l;
        int less = l - 1;
        int num = array[r];
        while (index <= r) {
            if (array[index] <= num) {
                ArrayUtils.swap(array, index, ++less);
            }
            index++;
        }
        return less;
    }
}
