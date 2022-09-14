package com.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Copyright (C), 2017-2021, 赵旭
 * Author: serendipity
 * Date: 2021/8/19 下午10:20
 * FileName: test01
 * Description: com.collection
 */
public class Test01 {

    public static void main(String[] args) {

        ArrayList<Integer> integers = new ArrayList<>();
        Arrays.binarySearch(new int[10], 10);
        int i = Collections.binarySearch(new ArrayList<Integer>(), 10);
    }
}
