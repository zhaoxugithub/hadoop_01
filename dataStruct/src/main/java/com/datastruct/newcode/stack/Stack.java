package com.datastruct.newcode.stack;

import com.datastruct.newcode.array.Array;

public class Stack<E> implements StackInterface<E> {

    private Array<E> array;

    public Stack(int capacity) {
        array = new Array<E>(capacity);
    }

    public Stack() {
        array = new Array<E>();
    }

    public int getSize() {
        return array.getSize();
    }

    public boolean isEmpty() {
        return array.isEmpty();
    }

    public void push(E e) {
        array.addLastElem(e);
    }

    public E pop() {
        return array.deleteLastEle();
    }

    public E peek() {
        return array.getEle(getSize() - 1);
    }

    @Override
    public String toString() {
        return "Stack{" +
                "array=" + array +
                '}';
    }
}
