package com.datastruct.oldcode.ch02;

import com.datastruct.oldcode.ch01.Array;

public class ArrayQueue<E> implements Queue {

    private Array<E> data;

    //无参构造
    public ArrayQueue() {
        data = new Array<>();
    }

    //有参构造
    public ArrayQueue(int capacity) {
        data = new Array<>(capacity);
    }

    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public void enqueue(Object o) {
        data.addLastElem((E) o);
    }

    @Override
    public Object dequeue() {
        return data.deleteFirstEle();
    }

    @Override
    public Object getFront() {
        return data.getEle(0);
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for (int i = 0; i < data.getSize(); i++) {
            res.append(data.getEle(i));
            if (i != data.getSize() - 1)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
