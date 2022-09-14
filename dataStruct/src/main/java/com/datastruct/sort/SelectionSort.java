package com.datastruct.sort;

public class SelectionSort {

    /**
     * 选择排序
     *
     * @param array
     */
    public void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int j = i + 1;
            for (int k = j; k < array.length; k++) {
                if (array[i] > array[k]) {
                    int temp = array[i];
                    array[i] = array[k];
                    array[k] = temp;
                }
            }
        }
    }
}
