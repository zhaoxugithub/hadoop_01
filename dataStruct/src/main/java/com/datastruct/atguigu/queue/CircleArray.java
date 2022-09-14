package com.datastruct.atguigu.queue;

public class CircleArray {

    private int maxSize;
    //front 变量的含义做一个调整： front 就指向队列的第一个元素, 也就是说 arr[front] 就是队列的第一个元素
    private int front;
    //rear 变量的含义做一个调整：rear 指向队列的最后一个元素的后一个位置. 因为希望空出一个空间做为约定
    private int rear;
    private int[] data;

    // 创建队列的构造器
    public CircleArray(int capacity) {
        maxSize = capacity;
        data = new int[capacity];
    }

    public CircleArray() {
        this(10);
    }

    // 入队
    public void addData(int data) {



    }

    // 出对
    public int popData() {
        return 0;
    }

    // 判空
    public boolean isEmpty() {
        return false;
    }

    // 判满
    public boolean isFull() {
        return false;
    }

    //展示
    public void showAll() {

    }

    //获取元素个数
    public int getDataSize() {
        return 0;
    }


    // 显示队列的头数据
    public int getHeader() {
        return 0;
    }
}
