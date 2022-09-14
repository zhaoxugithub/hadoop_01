package com.datastruct.oldcode.ch06;

/**
 * leetcode203
 * 删除链表中等于给定值 val 的所有节点。
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class RemoveElements {
    /**
     * 方法一：不设置头结点
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        //如果头结点是要被删除的节点
        while (head != null && head.val == val) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }
        //如果头结点是null，只能放在中间
        if (head == null) {
            return null;
        }
        //如果头结点不是要被删除的节点
        ListNode pre = head;
        while (pre.next != null) {

            if (pre.next.val == val) {
                ListNode delNode = pre.next;
                pre.next = delNode.next;
                delNode.next = null;
            } else {
                pre = pre.next;
            }
        }
        return head;
    }

    /**
     * 设置虚拟头结点
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements2(ListNode head, int val) {

        //创建一个虚拟头结点
        ListNode vmNode = new ListNode(-1);
        vmNode.next = head;

        ListNode preNode = vmNode;

        while (preNode.next != null) {

            if (preNode.next.val == val) {
                preNode.next = preNode.next.next;
            } else {
                preNode = preNode.next;
            }
        }
        //重点：不能返回head,只能返回vmNode.next;
        return vmNode.next;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 6, 9, 7, 8, 6, 5, 6};
        ListNode listNode = new ListNode(arr);
        System.out.println(listNode.toString());
        new RemoveElements().removeElements(listNode, 6);
        System.out.println(listNode.toString());
    }
}
