package com.ch01;

/**
 * Copyright (C), 2017-2021, 赵旭
 * Author: serendipity
 * Date: 2021/8/26 上午10:31
 * FileName: Code_01_DeleteDuplicates
 * Description: com.ch01 删除递增链表重复元素
 */
public class Code_01_DeleteDuplicates {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head;
        ListNode next = head.next;

        while (next != null) {
            if (pre.val == next.val) {
                ListNode temp = next;
                next = temp.next;
                pre.next = next;
                temp.next = null;
            } else {
                pre = pre.next;
                next = next.next;
            }
        }
        return head;
    }

}
