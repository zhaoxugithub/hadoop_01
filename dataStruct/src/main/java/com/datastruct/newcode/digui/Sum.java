package com.datastruct.newcode.digui;

public class Sum {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        int sum = sum(arr, arr.length - 1);
        System.out.println(sum);


    }

    public static int sum(int[] arr, int n) {
        if (n == 0) {
            return arr[n];
        }
        return arr[n] + sum(arr, n - 1);
    }
}
