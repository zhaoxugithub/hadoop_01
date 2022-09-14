package com.java.thread.c_005;

/**
 * Copyright (C), 2017-2021, 赵旭
 * Author: serendipity
 * Date: 2021/8/31 12:53 下午
 * FileName: T
 * Description: com.java.thread.c_005
 */
public class T implements Runnable {

    private int count = 100;

    @Override
    public synchronized void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + "-->" + count);
    }

    public static void main(String[] args) {
        T t = new T();
        for (int i = 0; i < 100; i++) {
            new Thread(t, "Thread" + i).start();
        }

    }
}
