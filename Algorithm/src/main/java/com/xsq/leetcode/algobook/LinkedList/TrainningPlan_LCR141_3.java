package com.xsq.leetcode.algobook.LinkedList;

import com.xsq.leetcode.Node.ListNode;

import java.util.LinkedList;

/**
 * LCR141.训练计划 III
 * 倒序返回链表 n
 */
public class TrainningPlan_LCR141_3 {
    public static void main(String[] args) {

    }

    /**
     * 辅助栈
     * O(n)、(n)
     */
    public ListNode trainningPlan(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<>();
        ListNode cur = head;
        while (cur != null) {
            stack.addLast(cur.val);
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            cur.val = stack.removeLast();
            cur = cur.next;
        }
        return head;
    }

    /**
     * 迭代(双指针)
     * O(n)、(1)
     */
    public ListNode trainningPlan2(ListNode head) {
        ListNode cur = head,pre = null;
        while (cur != null) {
            ListNode temp = cur.next;// 暂存后继节点 cur.next
            cur.next = pre;// 修改 next 引用指向
            pre = cur;// pre 暂存 cur
            cur = temp;// cur 访问下一节点
        }
        return pre;
    }

    /**
     * 递归
     * O(n)、(n)
     */
    public ListNode trainningPlan3(ListNode head) {
        return recur(head, null);
    }

    private ListNode recur(ListNode cur, ListNode pre) {
        if (cur == null) return pre;
        ListNode res = recur(cur.next, cur);
        cur.next = pre;
        return res;
    }
}
