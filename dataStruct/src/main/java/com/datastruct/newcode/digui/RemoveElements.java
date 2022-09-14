package com.datastruct.newcode.digui;

import com.datastruct.oldcode.ch06.ListNode;

public class RemoveElements {

    public static void main(String[] args) {
    }

    /**
     * 递归删除
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode res = removeElements(head.next, val);
        if (head.val == val) {
            return res;
        } else {
            head.next = res;
            return head;
        }
    }
}

