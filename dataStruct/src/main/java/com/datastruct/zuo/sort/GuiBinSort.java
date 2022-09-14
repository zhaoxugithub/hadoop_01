package com.datastruct.zuo.sort;

import com.datastruct.zuo.common.ArrayUtils;

/**
 * 归并排序:先分再合并
 *
 * 三个特点：
 *          l ==r
 *          sort() sort(), merge
 *          arr ,l ,r   => arr,l,mid,r
 */
public class GuiBinSort {

    public static void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int p1 = l;
        int p2 = mid + 1;
        int i = 0;
        while (p1 <= mid && p2 <= r) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (int k = 0; k < help.length; k++) {
            arr[l + k] = help[k];
        }
    }


//---------------------------复习一------------------------------------

    public static void sort2(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        sort(array, 0, array.length - 1);
    }

    public static void sort2(int[] array, int l, int r) {
        if (l == r) return;
        int mid = l + ((r - l) >> 1);
        sort2(array, l, mid);
        sort2(array, mid + 1, r);
        merge2(array, l, mid, r);
    }

    public static void merge2(int[] array, int l, int mid, int r) {

        int[] help = new int[r - l + 1];
        int p1 = l;
        int p2 = mid + 1;
        int i = 0;

        while (p1 <= mid && p2 <= r) {
            help[i++] = array[p1] > array[p2] ? array[p2++] : array[p1++];
        }
        while (p1 <= mid) {
            help[i++] = array[p1++];
        }
        while (p2 <= r) {
            help[i++] = array[p2++];
        }

        for (int j = 0; j < help.length; j++) {
            array[l + j] = help[j];
        }
    }

    public static void main(String[] args) {
        int[] array = ArrayUtils.generateRandomArray(10, 10, 0);
        ArrayUtils.printArr(array);
        sort2(array);
        ArrayUtils.printArr(array);
    }
}
