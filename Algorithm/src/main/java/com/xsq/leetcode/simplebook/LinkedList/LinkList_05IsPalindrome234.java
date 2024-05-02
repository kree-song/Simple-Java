package com.xsq.leetcode.simplebook.LinkedList;

import com.xsq.leetcode.Node.ListNode;

import java.util.ArrayList;

/**
 * 234.回文链表
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false
 */
public class LinkList_05IsPalindrome234 {
    public static void main(String[] args) {
        ListNode node4 = new ListNode(1);
        ListNode node3 = new ListNode(2,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);
        System.out.println(new LinkList_05IsPalindrome234().isPalindrome2(node1));
    }

    /**
     * 借用数组，将值复制到数组中后用双指针法
     * O(n)、O(n)
     */
    public static boolean isPalindrome1(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>(16);
        ListNode node = head;
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }

        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            if (!list.get(left).equals(list.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    private ListNode front;
    private boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) {
                return false;
            }
            if (currentNode.val != front.val) {
                return false;
            }
            front = front.next;
        }
        return true;
    }
    /**
     * 递归
     * O(n)、O(n)
     * 这种方法不仅使用了O(n)的空间，且比第一种方法更差，因为在许多语言中，堆栈帧的开销很大(如Python)，并且最大的运行时堆栈深度为1000
     * (可以增加，但是有可能导致底层解释程序内存出错)。为每个节点创建堆栈帧极大的限制了算法能够处理的最大链表大小
     */
    public boolean isPalindrome2(ListNode head) {
        front = head;
        return recursivelyCheck(head);
    }
}
