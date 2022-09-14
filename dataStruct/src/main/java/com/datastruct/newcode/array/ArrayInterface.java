package com.datastruct.newcode.array;

/**
 * 线性表接口
 *
 * @param <E>
 */
public interface ArrayInterface<E> {
    /**
     * 获取容量
     *
     * @return
     */
    int getCapacity();

    /**
     * 获取元素个数
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
     * 添加
     *
     * @param index
     * @param e
     */
    void addElem(int index, E e);

    /**
     * 添加第一个
     *
     * @param e
     */
    void addFirstElem(E e);

    /**
     * 添加最后一个
     *
     * @param e
     */
    void addLastElem(E e);

    /**
     * 根据下标获取元素
     *
     * @param index
     * @return
     */
    E getEle(int index);

    /**
     * 根据下标修改元素
     *
     * @param index
     * @param e
     */
    void updateEle(int index, E e);

    /**
     * 查找数组中是否含有这个元素
     *
     * @param e
     * @return
     */
    boolean isHasEle(E e);

    /**
     * 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
     *
     * @param e
     * @return
     */
    int getIndex(E e);

    /**
     * 从数组中删除index位置的元素, 返回删除的元素
     *
     * @param index
     * @return
     */
    E deleteEleByIndex(int index);

    /**
     * 从数组中删除第一个元素, 返回删除的元素
     *
     * @return
     */
    E deleteEleFirstEle();

    /**
     * 从数组中删除最后一个元素, 返回删除的元素
     *
     * @return
     */
    E deleteLastEle();

    /**
     * 从数组中删除元素e
     *
     * @param e
     * @return
     */
    void deleteEle(E e);

    /**
     * 将数组空间的容量变成newCapacity大小(扩容)
     *
     * @param newCapacity
     */
    void resize(int newCapacity);

    /**
     * 获取首元素
     *
     * @return
     */
    E getFirstEle();

    /**
     * 获取尾元素
     *
     * @return
     */
    E getLastEle();
}
