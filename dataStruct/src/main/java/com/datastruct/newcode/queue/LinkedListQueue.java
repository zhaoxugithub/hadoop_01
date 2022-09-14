package com.datastruct.newcode.queue;

/**
 * 链表队列
 *
 * @param <E>
 */
public class LinkedListQueue<E> implements QueueInterface<E> {

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

    private Node dummyNode;
    private int size;
    private Node front;
    private Node tail;

    public LinkedListQueue() {
        dummyNode = new Node();
        size = 0;
        // front = dummyNode;
        tail = dummyNode;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(E e) {
        tail.next = new Node(e, tail.next);
        tail = tail.next;
        size++;
    }

    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        Node toDeleteNode = dummyNode.next;
        dummyNode.next = toDeleteNode.next;
        size--;
        toDeleteNode.next = null;
        return toDeleteNode.data;
    }

    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        return dummyNode.next.data;
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front ");

        Node cur = dummyNode.next;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }

    public static void main(String[] args) {

        LinkedListQueue<Integer> queue = new LinkedListQueue<Integer>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
