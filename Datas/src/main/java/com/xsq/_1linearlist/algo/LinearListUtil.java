package com.xsq._1linearlist.algo;

import com.xsq._0node.ListNode;

public class LinearListUtil {
    /**
     * 初始化
     */
    void init() {
        //初始化链表 1 -> 3 -> 2
        ListNode n0 = new ListNode(1);// 初始化各个节点
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        n0.next = n1;// 构建节点之间的引用
        n1.next = n2;
    }

    /**
     * 增：在链表的节点 n0 之后插入节点 P
     */
    void insert(ListNode n0, ListNode P) {
        P.next = n0.next;
        n0.next = P;
    }

    /**
     * 删：删除链表的节点 n0 之后的首个节点
     */
    void remove(ListNode n0) {
        if (n0.next == null)
            return;
        // n0 -> P -> n1
        ListNode P = n0.next;
        ListNode n1 = P.next;
        n0.next = n1;
    }

    /**
     * 查：访问链表中索引为 index 的节点
     */
    ListNode access(ListNode head, int index) {
        for (int i = 0; i < index; i++) {
            if (head == null)
                return null;
            head = head.next;
        }
        return head;
    }

    /**
     * 查：在链表中查找值为 target 的首个节点
     */
    int find(ListNode head, int target) {
        int index = 0;
        while (head != null) {
            if (head.val == target)
                return index;
            head = head.next;
            index++;
        }
        return -1;
    }
}
