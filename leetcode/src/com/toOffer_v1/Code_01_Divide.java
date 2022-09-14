package com.toOffer_v1;

/**
 * Copyright (C), 2017-2021, 赵旭
 * Author: serendipity
 * Date: 2021/8/30 8:22 下午
 * FileName: Code_01_Divide
 * Description: com.toOffer_v1
 */
public class Code_01_Divide {

    public int divide(int a, int b) {
        if (b == 0) return -1;
        if (a == 0) return a;
        for (int i = 1; i <= a; i++) {

            if (b * i == a) {
                return i;
            } else if (b * i < a && b * (i + 1) <= Integer.MAX_VALUE && b * (i + 1) > a) {
                return i;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int divide = new Code_01_Divide().divide(10, 3);
        System.out.println(divide);
    }
}
