package com.datastruct.newcode.array;


import java.util.Arrays;

public class Array<E> implements ArrayInterface<E> {

    private E[] data;
    private int size;

    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    @Override
    public int getCapacity() {
        return data.length;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void addElem(int index, E e) {

        if (index > size || index < 0) {
            throw new IllegalArgumentException("index is Error");
        }

        if (size == data.length) {
            resize(2 * getCapacity());
        }

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = e;
        size++;
    }

    @Override
    public void addFirstElem(E e) {
        addElem(0, e);
    }

    @Override
    public void addLastElem(E e) {
        addElem(size, e);
    }

    @Override
    public E getEle(int index) {
        if (index > size || index < 0) {
            throw new IllegalArgumentException("index is Error");
        }
        return data[index];
    }

    @Override
    public void updateEle(int index, E e) {
        if (index > size || index < 0) {
            throw new IllegalArgumentException("index is Error");
        }
        data[index] = e;
    }

    @Override
    public boolean isHasEle(E e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(data[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int getIndex(E e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public E deleteEleByIndex(int index) {
        if (index > size || index < 0) {
            throw new IllegalArgumentException("index is Error");
        }
        E result = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        data[size] = null;
        if (size == data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);
        return result;
    }

    @Override
    public E deleteEleFirstEle() {
        return deleteEleByIndex(0);
    }

    @Override
    public E deleteLastEle() {
        return deleteEleByIndex(size - 1);
    }

    @Override
    public void deleteEle(E e) {
        int index = getIndex(e);
        if (index != -1) {
            deleteEleByIndex(index);
        }
    }

    @Override
    public void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public E getFirstEle() {
        if (isEmpty()) {
            throw new IllegalArgumentException("this array is empty");
        }
        return data[0];
    }

    @Override
    public E getLastEle() {
        if (isEmpty()) {
            throw new IllegalArgumentException("this array is empty");
        }
        return data[size - 1];
    }

    @Override
    public String toString() {
        return "Array{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }
}
