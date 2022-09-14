package com.datastruct.oldcode.ch06;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }


    ListNode(int[] arr) {

        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("this array is empty!");
        }
        ListNode cur = this;
        this.val = arr[0];
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            sb.append(cur.val);
            sb.append("->");
            cur = cur.next;
        }
        sb.append("NULL");
        return sb.toString();
    }
}
