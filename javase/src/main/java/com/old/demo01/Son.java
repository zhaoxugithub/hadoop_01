package com.old.demo01;

/**
 * Copyright (C), 2017-2021, 赵旭
 * Author: serendipity
 * Date: 2021/9/8 12:04 上午
 * FileName: Son
 * Description: com.duotai.demo01
 */
public class Son extends Father {

    int a = 8;

    public void display() {
        say();
        run();

    }


    public void run() {
        System.out.println("son run");
    }

    public void say() {
        System.out.println("son say" + a);
    }
}
