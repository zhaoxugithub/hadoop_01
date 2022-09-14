package com.datastruct.zuo.sort;

import com.datastruct.zuo.common.ArrayUtils;

public class GuiBinSort2 {

    public static void main(String[] args) {
        int[] array = ArrayUtils.generateRandomArray(10, 100, 2);
        ArrayUtils.printArr(array);
        sort(array);
        ArrayUtils.printArr(array);
    }


    public static void sort(int[] array) {

        if (array == null || array.length == 1) return;
        sort(array, 0, array.length - 1);

    }

    public static void sort(int[] array, int l, int r) {
        if (l == r) return;
        int mid = l + ((r - l) >> 1);
        sort(array, l, mid);
        sort(array, mid + 1, r);
        merge(array, l, mid, r);
    }


    public static void merge(int[] array, int l, int mid, int r) {

        int[] help = new int[r - l + 1];

        int pre = l;
        int old = mid + 1;

        int i = 0;
        while (pre <= mid && old <= r) {
            help[i++] = array[pre] < array[old] ? array[pre++] : array[old++];
        }

        while (pre <= mid) {
            help[i++] = array[pre++];
        }

        while (old <= r) {
            help[i++] = array[old++];
        }

        for (int k = 0; k < help.length; k++) {
            array[l + k] = help[k];
        }


    }
}
