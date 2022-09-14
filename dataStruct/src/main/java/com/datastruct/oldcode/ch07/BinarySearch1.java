package com.datastruct.oldcode.ch07;

public class BinarySearch1 {


    /**
     * 二分查找
     *
     * @param a
     * @param value
     * @return
     */
    public static int binarysearch(int[] a, int value) {

        int low = 0;
        int high = a.length - 1;
        int mid = (low + high) / 2;
        while (low <= high) {
            if (value > a[mid]) {
                low = mid + 1;
            } else if (value < a[mid]) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int binarysearch2() {
        return 0;
    }
}
