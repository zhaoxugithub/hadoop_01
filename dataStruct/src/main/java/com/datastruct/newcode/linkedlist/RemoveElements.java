package com.datastruct.newcode.linkedlist;


import com.datastruct.oldcode.ch06.ListNode;
import org.w3c.dom.ls.LSInput;

/**
 * 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class RemoveElements {

    //这个是带有头结点的
    public ListNode removeElements(ListNode head, int val) {

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode pre = dummyNode;
        ListNode sec = dummyNode.next;

        while (sec != null) {
            if (sec.val == val) {
                pre.next = sec.next;
                sec.next = null;
                sec = pre.next;
            } else {
                pre = sec;
                sec = sec.next;
            }

        }
        return dummyNode.next;
    }

    //下面是不带有头结点的
    public ListNode removeElements2(ListNode head, int val) {
        //如果头结点就是需要删除的元素，需要重新选择头结点
        while (head != null) {
            if (head.val != val) {
                break;
            }
            head = head.next;
        }
        //此时的头结点指向一个不是被删除的节点的元素
        //执行cur节点的前一个节点
        ListNode pre = head;
        //遍历指针
        ListNode cur = head;

        while (cur != null) {

            if (cur.val == val) {
                //todo
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;

        }
        return head;
    }
}
