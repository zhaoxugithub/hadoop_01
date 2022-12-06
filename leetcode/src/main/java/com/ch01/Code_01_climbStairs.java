package com.ch01;

/**
 * Copyright (C), 2017-2021, 赵旭
 * Author: serendipity
 * Date: 2021/8/26 上午10:18
 * FileName: climbStairs
 * Description: com.ch01
 */
public class Code_01_climbStairs {

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int sum = 0, a = 1, b = 2;
        for (int i = 3; i <= n; i++) {
            sum = a + b;

            a = b;
            b = sum;
        }
        return sum;
    }

    public int ccc(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return ccc(n - 2) + ccc(n - 1);
    }

    public static void main(String[] args) {
        Code_01_climbStairs code_01_climbStairs = new Code_01_climbStairs();
        System.out.println(code_01_climbStairs.climbStairs(10));
        System.out.println(code_01_climbStairs.ccc(10));

    }
}
