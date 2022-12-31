package com.datastruct.atguigu.queue;

public class ArrayQueue {

    private int[] arr;
    private int front;
    private int rear;
    private int capacity;

    // 创建队列的构造器
    public ArrayQueue(int arrMaxSize) {
        capacity = arrMaxSize;
        arr = new int[capacity];
        front = -1;// 指向队列头部，分析出 front 是指向队列头的前一个位置
        rear = -1;// 指向队列尾，指向队列尾的数据(即就是队列最后一个数据)
    }

    public ArrayQueue() {
        this(10);
    }

    // 判断队列是否满
    public boolean isFull() {
        return rear == capacity - 1;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return front == rear;
    }

    // 添加数据到队列
    public void pushData(int data) {
        if (isFull()) {
            System.out.println("队列满，不能加入数据");
            return;
        }
        arr[++rear] = data;
    }

    // 获取队列的数据, 出队列
    public int popData() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，不能取数据");
        }
        front++;
        return arr[front];
    }

    // 显示队列的所有数据
    public void showAll() {
        System.out.print("Array:[");
        for (int i = front + 1; i <= rear; i++) {
            if (i != rear) {
                System.out.print(arr[i] + ",");
            } else {
                System.out.print(arr[i]);
            }
        }
        System.out.println("]");

    }

    // 显示队列的头数据， 注意不是取出数据
    public int getData() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，不能取数据");
        }
        return arr[front + 1];
    }
}
