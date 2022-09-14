package com.datastruct.test;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Copyright (C), 2017-2022, 赵旭
 * Author: 11931
 * Date: 2022/2/20 13:25
 * FileName: TestCompator
 * Description: com.datastruct.test
 */
public class TestCompator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1 > o2) {
            return -1;
        } else {
            return 1;
        }
    }


    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int random = (int) (Math.random() * 100);
            integers.add(random);
        }
        System.out.println(integers);
        integers.sort(new TestCompator());
        System.out.println(integers);

    }
}
