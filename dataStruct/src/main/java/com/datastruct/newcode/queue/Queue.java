package com.datastruct.newcode.queue;

import com.datastruct.newcode.array.Array;

public class Queue<E> implements QueueInterface<E> {

    private Array<E> array;

    public Queue(int capacity) {
        array = new Array<>(capacity);
    }

    public Queue() {
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        array.addLastElem(e);
    }

    @Override
    public E dequeue() {
        return array.deleteEleFirstEle();
    }

    @Override
    public E getFront() {
        return array.getFirstEle();
    }

    @Override
    public String toString() {
        return "Queue{" +
                "array=" + array +
                '}';
    }
}
