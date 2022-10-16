package com.datastruct.zuo.line;

import com.datastruct.zuo.common.ArrayUtils;
import com.datastruct.zuo.common.LinkedListUtils;
import com.datastruct.zuo.common.ListNode;

/**
 * ClassName Code_01_PrintList
 * Description TODO
 * Author 11931
 * Date 2022-10-16:11:03
 * Version 1.0
 **/
public class Code_01_PrintList {

    public static void printList(ListNode<Integer> head) {
        System.out.print(head.val + " ");
        if (head.next != null) {
            printList(head.next);
        }
    }

    public static void main(String[] args) {
        int[] ints = ArrayUtils.generateRandomArray(10, 100, 1);
        ArrayUtils.printArr(ints);
        ListNode<Integer> listNode = LinkedListUtils.createListNode(ints);
        LinkedListUtils.printListNode(listNode);
        printList(listNode);
    }
}
