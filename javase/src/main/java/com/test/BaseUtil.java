package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Copyright (C), 2017-2021, 赵旭
 * Author: serendipity
 * Date: 2021/8/20 上午11:57
 * FileName: BaseUtil
 * Description: com.test
 */
public class BaseUtil {

    public static void main(String[] args) {
        int aa = 1;
        boolean naN1 = Float.isNaN(aa);
        System.out.println(naN1);
        boolean naN = Float.isNaN(22);
        System.out.println(naN);
        int i = tableSizeFor(9);
        System.out.println(i);
        HashMap<String, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        List list = new ArrayList();
        Integer vv = 23;
        int i1 = vv.hashCode();
        int h;

    }


    public static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= Integer.MAX_VALUE) ? Integer.MAX_VALUE : n + 1;
    }
    

}
