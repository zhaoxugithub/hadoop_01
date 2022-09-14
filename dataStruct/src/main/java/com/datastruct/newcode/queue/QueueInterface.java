package com.datastruct.newcode.queue;

public interface QueueInterface<E> {

    /**
     * 获取队列的元素个数
     *
     * @return
     */
    int getSize();

    /**
     * 获取容量
     *
     * @return
     */
    int getCapacity();

    /**
     * 判空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 入队
     *
     * @param e
     */
    void enqueue(E e);

    /**
     * 出队
     *
     * @return
     */
    E dequeue();

    /**
     * 获取对头元素
     *
     * @return
     */
    E getFront();
}
