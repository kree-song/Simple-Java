package src.com.xsq.leetcode.simplebook.LinkedList;

import com.xsq.leetcode.Node.ListNode;

/**
 * 21.合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
 */
public class LinkList_04MergeTwoLists21 {
    public static void main(String[] args) {

    }

    /**
     * 递归
     * 时：O(n+m) 空：O(n+m)
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /**
     * 迭代
     * 时：O(n+m) 空：O(1)
     */
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        //最后至多还有一个未合并完，直接接入即可
        prev.next = l1 == null ? l2 : l1;
        return preHead.next;
    }
}
