package com.datastruct.atguigu.linklist;


public class LinkedNode<E> {
    public E data;
    public LinkedNode next;

    public LinkedNode(E data, LinkedNode next) {
        this.data = data;
        this.next = next;
    }

    public LinkedNode(E data) {
        this(data, null);
    }

    public LinkedNode() {
        this(null, null);
    }

    @Override
    public String toString() {
        return "LinkedNode{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
