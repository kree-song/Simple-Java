package src.com.xsq.leetcode.questionBank.LinkedList;

import com.xsq.leetcode.Node.ListNode;

/*
 *实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 * */
public class LinkedList_kthToLast_0202 {
    int count;
    int res;

    public static void main(String[] args) {

    }

    public int kthToLast(ListNode head, int k) {
        // 使用计数器，递归返回过程中倒数第k个结点
        count = k;
        search_kthToLast(head);
        return res;
    }

    private void search_kthToLast(ListNode head) {
        if (head != null) {
            search_kthToLast(head.next);
        }
        if ((--count) == -1) {
            res = head.val;
        }
    }
}
