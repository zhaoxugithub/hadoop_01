package com.datastruct.oldcode.ch01;

/**
 * 用数组实现ArrayList
 *
 * @param <E>
 */
public class Array<E> {

    private E[] data;
    private int size;

    // 构造函数，传入数组的容量capacity构造Array
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    // 无参数的构造函数，默认数组的容量capacity=10
    public Array() {
        this(10);
    }

    // 获取数组的容量
    public int getCapacity() {
        return data.length;
    }

    // 获取数组中的元素个数
    public int getSize() {
        return size;
    }

    // 返回数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 在index索引的位置插入一个新元素e
    public void addElem(int index, E e) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
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

    // 向所有元素后添加一个新元素
    public void addLastElem(E e) {
        addElem(size, e);
    }

    // 在所有元素前添加一个新元素
    public void addFirstElem(E e) {
        addElem(0, e);
    }

    // 获取index索引位置的元素
    public E getEle(int index) {

        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }
        return data[index];
    }

    // 修改index索引位置的元素为e
    public void updateEle(int index, E e) {

        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }
        data[index] = e;
    }

    // 查找数组中是否有元素e
    public boolean isHasEle(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }

    // 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
    public int getIndex(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    // 从数组中删除index位置的元素, 返回删除的元素
    public E deleteEleByindex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }
        E res = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        data[size] = null;

        return res;
    }

    // 从数组中删除第一个元素, 返回删除的元素
    public E deleteFirstEle() {
        E ele = deleteEleByindex(0);
        return ele;
    }

    // 从数组中删除最后一个元素, 返回删除的元素
    public E deleteLastEle() {
        E ele = deleteEleByindex(size - 1);
        return ele;
    }

    // 从数组中删除元素e
    public E deleteEle(E e) {
        int index;
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                index = i;
            }
        }
        return e;
    }

    // 将数组空间的容量变成newCapacity大小
    public void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }
}
