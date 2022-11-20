package com.datastruct.newcode.digui;

import com.datastruct.zuo.common.ArrayUtils;
import com.datastruct.zuo.common.LinkedListUtils;
import com.datastruct.zuo.common.ListNode;

public class RemoveElements {
    /**
     * 非递归删除
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode<Integer> removeEle(ListNode<Integer> head, int val) {
        ListNode<Integer> pHead = new ListNode<Integer>(-1);
        pHead.next = head;
        ListNode<Integer> fast = head;
        ListNode<Integer> slow = pHead;
        while (fast != null) {
            if (fast.val == val) {
                slow.next = fast.next;
                fast = slow.next;
            } else {
                fast = fast.next;
                slow = slow.next;
            }
        }
        return pHead.next;
    }

    /**
     * 递归删除
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode<Integer> removeEle2(ListNode<Integer> head, int val) {
        if (head == null) {
            return null;
        }
        // head 当前节点
        if (head.val == val) {
            return removeEle2(head.next, val);
        } else {
            head.next = removeEle2(head.next, val);
            return head;
        }
    }

    /**
     * 递归删除
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode<Integer> removeElements(ListNode<Integer> head, int val) {
        if (head == null) {
            return null;
        }
        ListNode<Integer> res = removeElements(head.next, val);
        if (head.val == val) {
            return res;
        } else {
            head.next = res;
            return head;
        }
    }

    public static void main(String[] args) {
        int[] ints = ArrayUtils.generateRandomArray(10, 100, 1);
        ListNode<Integer> listNode = LinkedListUtils.createListNode(ints);
        LinkedListUtils.printListNode(listNode);

        // ListNode<Integer> integerListNode = LinkedListUtils.copyLinkedNode(listNode);
        // LinkedListUtils.printListNode(integerListNode);

        ListNode<Integer> integerListNode1 = removeElements(listNode, listNode.val);
        LinkedListUtils.printListNode(integerListNode1);
    }
}

