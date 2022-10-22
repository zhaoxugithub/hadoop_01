package com.old.test;

import java.util.Arrays;

/**
 * Copyright (C), 2017-2021, 赵旭
 * Author: serendipity
 * Date: 2021/8/28 11:57 上午
 * FileName: Test_for
 * Description: com.test
 */
public class Test_for {

    public static void main(String[] args) {
        long s = System.currentTimeMillis();
        System.out.println(s);
        long sum = 0;
        for (long i = 0; i < 9000000000L; i++) {
            sum += i;
        }
        System.out.println(sum);
        System.out.println(System.currentTimeMillis() - s);
        StringBuffer sb = new StringBuffer();

    }

    //计算时差函数











}
