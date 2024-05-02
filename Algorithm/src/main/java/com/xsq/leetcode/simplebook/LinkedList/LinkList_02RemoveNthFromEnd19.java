package com.xsq.leetcode.simplebook.LinkedList;

import com.xsq.leetcode.Node.ListNode;

/**
 * 19.删除链表的倒数第N个节点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class LinkList_02RemoveNthFromEnd19 {
    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {//12 1

        ListNode p = head, q = head;
        ListNode m = new ListNode(0, head);
        //遍历算出总结点数
        int count = 0;
        while (p != null) {
            count++;
            p = p.next;
        }

        //找到倒数第n个结点
        int num = count - n;
        if (num == 0) {   //若是头结点直接返回next
            return head.next;
        }
        while (num > 0) {
            q = q.next;
            m = m.next;
            num--;
        }

        if (q.next == null) {//若为最后一个结点，直接令其为空
            m.next = null;
        } else {
            q.val = q.next.val;
            q.next = q.next.next;
        }

        return head;

    }
}
