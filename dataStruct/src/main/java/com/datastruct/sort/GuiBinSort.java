package com.datastruct.sort;


public class GuiBinSort {

    public void sort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        sort(array, 0, array.length - 1);
    }

    public void sort(int[] array, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        sort(array, l, mid);
        sort(array, mid + 1, r);
        merge(array, l, mid, r);
    }


    public void merge(int[] array, int l, int mid, int r) {

        int[] help = new int[r - l + 1];
        int p1 = l;
        int p2 = mid + 1;
        int i = 0;

        while (p1 <= mid && p2 <= r) {
            help[i++] = array[p1] <= array[p2] ? array[p1++] : array[p2++];
        }

        while (p1 <= mid) {
            help[i++] = array[p1++];
        }
        while (p2 <= r) {
            help[i++] = array[p2++];
        }

        for (int k = 0; k < help.length; k++) {
            array[l + k] = help[k];
        }
    }
}
