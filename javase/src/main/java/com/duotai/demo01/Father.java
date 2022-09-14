package com.duotai.demo01;

/**
 * Copyright (C), 2017-2021, 赵旭
 * Author: serendipity
 * Date: 2021/9/8 12:01 上午
 * FileName: Father
 * Description: com.duotai.demo01
 */
public class Father {

    int a = 10;

    public void display() {
        say();
        run();
    }


    private void say() {
        System.out.println("fsay" + a);
    }

    public void run() {
        System.out.println("frun");
    }
}
