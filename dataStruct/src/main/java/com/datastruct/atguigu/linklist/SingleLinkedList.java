package com.datastruct.atguigu.linklist;

/**
 * 包括头结点
 */
public class SingleLinkedList<E> {
    private LinkedNode headNode;
    private int size;

    public SingleLinkedList() {
        headNode = new LinkedNode();
        size = 0;
    }

    //获取数据个数
    public int getSize() {
        return size;
    }

    //判断是否包含数据
    public boolean isContains(E e) {
        if (isEmpty()) {
            return false;
        }
        LinkedNode preNode = headNode;
        while (preNode.next != null) {
            if (e.equals(preNode.next.data)) {
                return true;
            }
            preNode = preNode.next;
        }
        return false;
    }

    //判空
    public boolean isEmpty() {
        return size == 0;
    }

    public void addData(int index, E e) {

        if (index > size) {
            //todo
        }

        LinkedNode preNode = headNode;
        //遍历到指定的位置的前一个
        for (int i = 0; i < index - 1; i++) {
            preNode = preNode.next;
        }
    }
    //修改某个元素的值
    //删除
    //获取指定下标的数据
    //获取指定元素的下标
    //遍历
}
