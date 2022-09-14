package com.datastruct.oldcode.ch07;

public class Sum_01 {


    /**
     * 求和方法一
     */
    public int sum1(int[] array) {

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    /**
     * 递归求和
     *
     * @param array
     * @return
     */
    public static int sum2(int[] array, int l) {
        if (l == 0) {
            return array[0];
        }
        return array[l] + sum2(array, l - 1);
    }

    public static void main(String[] args) {
        int[] array = new int[]{3, 5, 7, 7, 8, 9, 9};
        int i = sum2(array, array.length - 1);
        System.out.println(i);
    }

}
