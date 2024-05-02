package com.xsq.leetcode.algobook.LinkedList;

import com.xsq.leetcode.Node.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * LCR123.图书整理 I
 * 倒序返回链表
 */
public class ReverseBookList_LCR123_1 {
    public static void main(String[] args) {

    }

    public static int[] reverseBookList(ListNode head) {
        ListNode node = head;
        ArrayList<Integer> nums = new ArrayList<>();
        while (node != null) {
            nums.add(node.val);
            node = node.next;
        }

        int[] ans = new int[nums.size()];
        int j = 0;
        for (int i = nums.size() - 1; i >= 0; i--) {
            ans[j++] = nums.get(i);
        }
        return ans;
    }


    /**
     * 递归
     * O(n)、O(n)
     */
    static ArrayList<Integer> temp = new ArrayList<>();
    public static int[] reverseBookList2(ListNode head) {
        recur(head);
        int[] ans = new int[temp.size()];
        for(int i = 0; i < ans.length; i++)
            ans[i] = temp.get(i);
        return ans;
    }

    private static void recur(ListNode head) {
        if (head == null) return;
        recur(head.next);
        temp.add(head.val);
    }

    /**
     * 辅助栈
     * O(n)、O(n)
     */
    public static int[] reverseBookList3(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<>();
        while (head != null) {
            stack.addLast(head.val);
            head = head.next;
        }

        int[] ans = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            ans[i] = stack.removeLast();
        }
        return ans;
    }
}
