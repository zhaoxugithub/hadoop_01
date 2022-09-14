package com.datastruct.newcode.linkedlist;

/**
 * 双向列表
 */
public class DoubleLinkedList {

    class Node {
        private int data;
        private Node next;
        private Node pre;

        public Node(int data, Node next, Node pre) {
            this.data = data;
            this.next = next;
            this.pre = pre;
        }

        public Node(int data) {
            this(data, null, null);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    ", pre=" + pre +
                    '}';
        }
    }

    private int length;
    private Node head;

    public DoubleLinkedList() {
        length = 0;
        head = null;
    }

    //链表头添加元素
    public void addHead(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head.pre = node;
            head = node;
        }
        length++;
    }

    //链表尾部添加元素
    public void addTail(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
        } else {
            int count = 1;
            Node cur = head;
            while (count < length) {
                cur = cur.next;
                count++;
            }
            cur.next = node;
            node.pre = cur;
            length++;
        }
    }

    //链表头部删除元素
    public void deleteHead() {

        if (head == null) {
            //todo
        } else {
            Node toDeleteNode = head;
            head = toDeleteNode.next;
            head.pre = null;
            length--;
        }
    }

    //链表尾部删除元素
    public void deleteTail() {
        if (head == null) {
            //todo
        } else {
            Node cur = head;
            int count = 1;
            while (count < length - 1) {
                cur = cur.next;
                count++;
            }
            cur.next = null;
        }
    }

    //正向遍历链表
    public void printPreOrder() {
        Node cur = head;
        while (cur.next != null) {
            String node = cur.toString();
            System.out.println(node);
            cur = cur.next;
        }
    }

    //逆向遍历链表
    public void printPostOrder() {
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        while (cur.pre != null) {
            String node = cur.toString();
            System.out.println(node);
            cur = cur.pre;
        }
    }


    //在指定位置插入结点
    public void insertByIndex(int data, int index) {

        if (index < 0 || index > length) {
            //todo
        }
        if (head == null) {
            head = new Node(data);
        }
        Node cur = head;
        int count = 1;
        while (count < index) {
            cur = cur.next;
            count++;
        }
        Node node = new Node(data);
        node.next = cur.next;
        cur.next.pre = node;
        node.pre = node;
        cur.next = node;
        length++;
    }

    //在指定位置删除结点
    public void deleteByIndex(int index) {
        if (index < 0 || index >= length) {
            //todo
        }
        if (head == null || length == 0) {
            //todo 空
        }
        int count = 1;
        Node cur = head;
        while (count < index) {
            cur = cur.next;
            count++;
        }
        Node toDelete = cur.next;
        cur.next = toDelete.next;
        toDelete.next.pre = cur;
        toDelete.next = null;
        length--;
    }

    //查找数据是否存在,与单链表一样
    public boolean isExist(int data) {
        Node cur = head;
        while (cur != null) {
            if (cur.data == data) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //获取指定位置的数据，与单链表一样
    public int getDataByIndex(int index) {
        if (index < 0 || index > length) {
            //todo
        }
        Node cur = head;
        for (int i = 1; i <= index; i++) {
            cur = cur.next;
        }
        return cur.data;
    }

    //修改指定位置的结点数据，与单链表一样
    public void updateData(int data, int index) {
        if (index < 0 || index > length) {
            //todo
        }

        Node cur = head;
        for (int i = 1; i <= index; i++) {
            cur = cur.next;
        }
        cur.data = data;
    }


    //打印链表
    public void showALL() {
        Node cur = head;
        System.out.print("[");
        while (cur != null) {
            System.out.print(cur.data);
            cur = cur.next;
            if (cur != null) {
                System.out.print("->");
            }
        }
        System.out.println("]");
    }

    @Override
    public String toString() {
        return "DoubleLinkedList{" +
                "length=" + length +
                ", head=" + head +
                '}';
    }

    //双向链表的反转
    public void reverse(){

    }


    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        for (int i = 0; i < 10; i++) {
            doubleLinkedList.addHead(i);
        }
        doubleLinkedList.showALL();

        doubleLinkedList.addTail(100);
        doubleLinkedList.showALL();


        doubleLinkedList.insertByIndex(200, 3);
        doubleLinkedList.showALL();

        doubleLinkedList.deleteHead();
        doubleLinkedList.showALL();


        doubleLinkedList.deleteTail();
        doubleLinkedList.showALL();

        doubleLinkedList.deleteByIndex(2);
        doubleLinkedList.showALL();


        boolean exist = doubleLinkedList.isExist(7);
        System.out.println(exist);

        doubleLinkedList.updateData(1000,1);
        doubleLinkedList.showALL();
    }
}
