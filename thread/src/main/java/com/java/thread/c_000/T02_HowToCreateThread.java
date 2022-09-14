package com.java.thread.c_000;

/**
 * Copyright (C), 2017-2021, 赵旭
 * Author: serendipity
 * Date: 2021/8/31 12:12 上午
 * FileName: T02_HowToCreateThread
 * Description: com.java.thread.c_001
 */
public class T02_HowToCreateThread {
    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("MyThread start ...");
        }
    }

    public static class MyRun implements Runnable {
        @Override
        public void run() {
            System.out.println("MyRun start ....");
        }
    }

    public static void main(String[] args) {
        //第一种方法
        new MyThread().start();
        //第二种方法
        new Thread(new MyRun()).start();
        //第三种方法
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("myRun start ........");
            }
        }).start();
        //第四种方法
        new Thread(() -> System.out.println("my start...")).start();
    }
}
