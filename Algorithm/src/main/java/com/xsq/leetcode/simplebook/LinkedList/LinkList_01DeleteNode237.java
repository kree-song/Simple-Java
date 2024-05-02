package com.xsq.leetcode.simplebook.LinkedList;

import com.xsq.leetcode.Node.ListNode;

/**
 * 237.删除链表中的节点
 * 请编写一个函数，用于删除单链表中某个特定节点 。在设计函数时需要注意，你无法访问链表的头节点head ，只能直接访问要被删除的节点
 * 题目数据保证需要删除的节点不是末尾节点
 */
public class LinkList_01DeleteNode237 {
    public static void main(String[] args) {

    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
