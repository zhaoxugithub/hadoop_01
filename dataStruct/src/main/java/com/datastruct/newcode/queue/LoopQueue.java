package com.datastruct.newcode.queue;


import java.util.Arrays;

/**
 * 循环队列
 *
 * front:指向队列中的第一个元素
 * rear:指向队列的最后一个元素的后一个位置
 * 循环队列判空：rear ==front
 * 循环队列判满：(rear+1)%length == front
 * 循环队列中的位置：rear%length
 * @param <E>
 */
public class LoopQueue<E> implements QueueInterface<E> {

    private E[] data;
    private int size;
    private int front;
    private int tail;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
        front = 0;
        tail = 0;
    }

    public LoopQueue() {
        this(10);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int getCapacity() {
        return data.length;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {

        if ((tail + 1) % data.length == front) {
            resize(2 * getCapacity());
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {

        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        E result = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);
        return result;

    }

    @Override
    public E getFront() {
        return data[front];
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        front = 0;
        tail = size;
        data = newData;
    }


    @Override
    public String toString() {
        return "LoopQueue{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                ", front=" + front +
                ", tail=" + tail +
                '}';
    }
}
