package com.datastruct.zuo.sort;

import com.datastruct.zuo.common.ArrayUtils;

/**
 * ClassName GuiBinSortV1_EX1
 * Description TODO
 * Author 11931
 * Date 2022-09-16:10:38
 * Version 1.0
 **/
public class GuiBinSortV1_EX1 {


    public static void main(String[] args) {
        int[] array = ArrayUtils.generateRandomArray(10, 10, 0);
        ArrayUtils.printArr(array);
        sort(array);
        ArrayUtils.printArr(array);

    }


    public static void sort(int[] array) {

        if (array == null || array.length == 0) {
            return;
        }

        sort(array, 0, array.length - 1);
    }

    public static void sort(int[] array, int start, int end) {
        if (start == end) return;
        int mid = start + ((end - start) >> 1);
        sort(array, start, mid);
        sort(array, mid + 1, end);
        merge(array, start, mid, end);
    }

    public static void merge(int[] array, int start, int mid, int end) {
        int[] helpArr = new int[end - start + 1];
        int p1 = start;
        int p2 = mid + 1;
        int index = 0;
        while (p1 <= mid && p2 <= end) {
            if (array[p1] < array[p2]) {
                helpArr[index] = array[p1];
                p1++;
            } else {
                helpArr[index] = array[p2];
                p2++;
            }
            index++;
        }

        while (p1 <= mid) {
            helpArr[index++] = array[p1++];
        }
        while (p2 <= end) {
            helpArr[index++] = array[p2++];
        }

        for (int i = 0; i < helpArr.length; i++) {
            array[start + i] = helpArr[i];
        }
    }
}
