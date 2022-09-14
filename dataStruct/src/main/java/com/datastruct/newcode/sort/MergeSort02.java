package com.datastruct.newcode.sort;

import java.util.Arrays;

public class MergeSort02 {

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

    public static void sort(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = (left + right) / 2;
        sort(arr, left, mid);
        sort(arr, mid + 1, right);
        merge(arr, left, mid, right);

    }


    //4,5,7,9|1,3,6,10
    public static void merge(int[] arr, int left, int mid, int right) {

        int[] temp = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;

        while (p1 <= mid && p2 <= right) {
            temp[i++] = arr[p1] >= arr[p2] ? arr[p2++] : arr[p1++];
        }

        while (p1 <= mid) {
            temp[i++] = arr[p1++];
        }
        while (p2 <= right) {
            temp[i++] = arr[p2++];
        }

        for (int k = 0; k < temp.length; k++) {
            arr[left + k] = temp[k];
        }
    }


}

