package com.datastruct.sort;

/**
 * 希尔排序
 */
public class ShellSort {
    // //[45, 53, 64, 17, 9, 38, 83, 15, 51, 18]
    public void sort(int[] array) {
        //gap 步进
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                int j = i;
                int temp = array[j];
            }
        }
    }
}
