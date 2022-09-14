package com.datastruct.newcode.linkedlist;


import com.datastruct.oldcode.ch06.ListNode;

public class LinkedList<E> implements LinkedInterface<E> {

    private class Node {

        private E data;
        private Node next;

        public Node(E e, Node next) {
            this.data = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node();
        size = 0;
    }

    public int getCapacity() {
        return 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addElem(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }

        pre.next = new Node(e, pre.next);
        size++;
    }

    public void addFirstElem(E e) {
        addElem(0, e);
    }

    public void addLastElem(E e) {
        addElem(size - 1, e);
    }

    public E getEle(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        Node pre = dummyHead.next;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        return pre.data;
    }

    public void updateEle(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        Node pre = dummyHead.next;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.data = e;
    }

    public boolean isHasEle(E e) {
        Node pre = dummyHead.next;
        for (int i = 0; i < size; i++) {
            if (e.equals(pre.data)) {
                return true;
            }
            pre = pre.next;
        }
        return false;
    }

    public int getIndex(E e) {
        Node pre = dummyHead.next;
        for (int i = 0; i < size; i++) {
            if (e.equals(pre.data)) {
                return i;
            }
            pre = pre.next;
        }
        return -1;
    }

    public E deleteEleByIndex(int index) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        Node toDeleteNode = pre.next;
        pre.next = toDeleteNode.next;
        toDeleteNode.next = null;
        size--;
        return toDeleteNode.data;
    }

    public E deleteEleFirstEle() {
        return deleteEleByIndex(0);
    }

    public E deleteLastEle() {
        return deleteEleByIndex(size - 1);
    }

    public void deleteEle(E e) {
        Node pre = dummyHead;
        for (int i = 0; i < size; i++) {
            if (e.equals(pre.next.data)) {
                Node toDeleteNode = pre.next;
                pre.next = toDeleteNode.next;
                toDeleteNode = null;
                size--;
            }
            pre = pre.next;
        }
    }

    public void resize(int newCapacity) {

    }

    public E getFirstEle() {
        return getEle(0);
    }

    public E getLastEle() {
        return getEle(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");

        return res.toString();
    }

    //单链表反转
    public void reverse(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
    }
}
