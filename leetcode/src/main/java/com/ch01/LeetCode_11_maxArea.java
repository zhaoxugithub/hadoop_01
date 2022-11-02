package com.ch01;

/**
 * ClassName LeetCode_11_maxArea
 * Description TODO
 * Author 11931
 * Date 2022-10-30:14:12
 * Version 1.0
 **/
public class LeetCode_11_maxArea {

    public static int maxArea(int[] height) {

        if (height == null || height.length == 0) {
            return 0;
        }
        int len = height.length;
        int area = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int y = Math.min(height[i], height[j]);
                int x = j - i;
                if (x * y > area) {
                    area = x * y;
                }
            }
        }
        return area;
    }


    public static void main(String[] args) {
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int i = maxArea(arr);
        System.out.println(i);
    }
}
