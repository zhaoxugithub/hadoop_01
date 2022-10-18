package com.ch01;

public class Offer_22_GetKthFromEnd {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            cur = cur.next;
            len++;
        }

        cur = head;
        for (int i = 1; i <= len - k; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public static void main(String[] args) {

    }
}
