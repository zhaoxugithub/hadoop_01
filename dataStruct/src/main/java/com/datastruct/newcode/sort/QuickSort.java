package com.datastruct.newcode.sort;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {


    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 4, 32, 4, 56, 3, 2, 96, 34};
        new QuickSort().quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * @param arr
     * @param start
     * @param end
     */
    public void quickSort(int[] arr, int start, int end) {

        int i = start;
        int j = end;
        int target = arr[start];
        while (i < j) {

            while (i < j && target <= arr[j]) j--;

            if (i < j) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
            while (i < j && target >= arr[i]) i++;
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        if (i - 1 > start) {
            quickSort(arr, start, i - 1);
        }
        if (j + 1 < end) {
            quickSort(arr, j + 1, end);
        }
    }


}
