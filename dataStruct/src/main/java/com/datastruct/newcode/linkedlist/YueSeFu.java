package com.datastruct.newcode.linkedlist;

/**
 * 约瑟夫问题
 */
public class YueSeFu {
    private Node tail;
    private int size = 0;

    class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * 注意一级索引和二级索引的区别
     *
     * @param data
     */
    public void addEle(int data) {
        if (tail == null) {
            tail = new Node(data, null);
            tail.next = tail;
        } else {
            Node node = new Node(data, null);
            node.next = tail.next;
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void show() {
        System.out.print("[");
        if (tail == null) {
            //todo
        } else {
            Node pre = tail.next;
            for (int i = 0; i < size; i++) {
                System.out.print(pre.data + "->");
                pre = pre.next;
            }
        }
        System.out.println("]");
    }

    /**
     * @param start 开始下标
     * @param step  步骤
     * @return
     */
    public void removeEle(int start, int step) {

        if (tail == null) {
            //todo
        }
        if (start < 0 || start > size) {
            //todo
        }
        Node p = tail.next;
        System.out.print("出队：[");
        while (p != null) {
            Node preDeleteNode = p;
            for (int i = 1; i < step - 1; i++) {
                preDeleteNode = preDeleteNode.next;
            }
            Node toDeleteNode = preDeleteNode.next;
            preDeleteNode.next = toDeleteNode.next;
            toDeleteNode.next = null;
            p = preDeleteNode.next;

            System.out.print(toDeleteNode.data);
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        YueSeFu yueSeFu = new YueSeFu();
        for (int i = 1; i < 10; i++) {
            yueSeFu.addEle(i);
        }
        yueSeFu.show();
        yueSeFu.removeEle(1,2);

    }

}
