package com.datastruct.oldcode.ch03;

public class LinkedList<E> {

    private class Node {
        public E e;
        public Node next;

        public Node() {
            this(null, null);
        }

        public Node(E e) {
            this(e, null);
        }

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    // 在链表的index(0-based)位置添加新的元素e
    // 在链表中不是一个常用的操作，练习用：）
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index is wrong!");
        }
        Node temp = dummyHead;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

//        Node newNode = new Node(e);
//        newNode.next = temp.next;
//        temp.next = newNode;
//        size++;
        temp.next = new Node(e, temp.next);
        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    // 在链表末尾添加新的元素e
    public void addLast(E e) {
        add(size, e);
    }

    // 获得链表的第index(0-based)个位置的元素
    // 在链表中不是一个常用的操作，练习用：）
    public E get(int index) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index is not Illegal");
        }
        Node temp = dummyHead;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.next.e;
    }

    // 获得链表的第一个元素
    public E getFirst() {
        return get(0);
    }

    // 获得链表的最后一个元素
    public E getLast() {
        return get(size - 1);
    }


    // 修改链表的第index(0-based)个位置的元素为e
    // 在链表中不是一个常用的操作，练习用：）
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index is not Illgel");
        }
        Node temp = dummyHead;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        temp.next.e = e;
    }

    // 查找链表中是否有元素e
    public boolean contains(E e) {
        Node tem = dummyHead;

        for (int i = 0; i < size; i++) {
            tem = tem.next;
            if (tem.e == e) {
                return true;
            }
        }
        return false;
    }

    // 从链表中删除index(0-based)位置的元素, 返回删除的元素
    // 在链表中不是一个常用的操作，练习用：）
    public E remove(int index) {

        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index is not Illegal");
        }
        Node tem = dummyHead;
        for (int i = 0; i < index; i++) {
            tem = tem.next;
        }
        Node res = tem.next;
        tem.next = res.next;
        res.next = null;
        size--;
        return res.e;
    }

    // 从链表中删除第一个元素, 返回删除的元素
    public E removeFirst() {
        return remove(0);
    }

    // 从链表中删除最后一个元素, 返回删除的元素
    public E removeLast() {
        return remove(size - 1);
    }

    // 从链表中删除元素e
    public void removeElement(E e) {
        Node tem = dummyHead;
        for (int i = 0; i < size; i++) {
            tem = tem.next;
            if (tem.next.e.equals(e)) {
                break;
            }
        }
        if (tem.next != null) {
            Node res = tem.next;
            tem.next = res.next;
            res.next = null;
            size--;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

//        Node cur = dummyHead.next;
//        while(cur != null){
//            res.append(cur + "->");
//            cur = cur.next;
//        }
        for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
            res.append(cur + "->");
        }
        res.append("NULL");

        return res.toString();
    }
}