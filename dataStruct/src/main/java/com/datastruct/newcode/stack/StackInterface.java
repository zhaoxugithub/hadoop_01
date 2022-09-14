package com.datastruct.newcode.stack;

public interface StackInterface<E> {
    /**
     * 获取栈元素个数
     *
     * @return
     */
    int getSize();

    /**
     * 判空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 入栈
     *
     * @param e
     */
    void push(E e);

    /**
     * 出栈
     *
     * @return
     */
    E pop();

    /**
     * 获取栈首
     *
     * @return
     */
    E peek();

}
