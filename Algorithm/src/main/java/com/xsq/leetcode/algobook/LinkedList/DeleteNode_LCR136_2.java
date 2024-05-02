package com.xsq.leetcode.algobook.LinkedList;

import com.xsq.leetcode.Node.ListNode;
/**
 * LCR136.删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点
 */
public class DeleteNode_LCR136_2 {
    public static void main(String[] args) {

    }

    /**
     * O(n),O(1)
     */
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) return head.next;

        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                return head;
            }
            pre = cur;
            cur = cur.next;
        }
        return head;
    }

    /**
     * 借助循环跳转到目标节点
     * O(n),O(1)
     */
    public ListNode deleteNode2(ListNode head, int val) {
        if (head.val == val) return head.next;

        ListNode pre = head,cur = head.next;
        while (cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        if (cur != null) pre.next = cur.next;
        return head;
    }

    /**
     * 单指针
     * O(n),O(1)
     */
    public ListNode deleteNode3(ListNode head, int val) {
        if(head.val == val) return head.next;

        ListNode cur = new ListNode(0);
        cur.next = head;
        while(cur.next != null ){
            if(cur.next.val == val){
                cur.next = cur.next.next;
                return head;
            }
            cur = cur.next;
        }
        return head;
    }
}
