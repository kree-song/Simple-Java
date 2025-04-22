package com.xsq;

import com.xsq.leetcode.Node.ListNode;
import com.xsq.leetcode.Node.TreeNode;
import java.util.*;

//public class ListNode {
//    int val;
//    ListNode next;
//    ListNode() {}
//    ListNode(int val) { this.val = val; }
//    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}

//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
public class MainTest {
    public static void main(String[] args) {


    }


    public ListNode reverse(ListNode head, int k) {
        ListNode pre = null,cur = head;
        int n = k;
        while (cur != null) {
            ListNode node  = cur.next;
            cur.next = pre;
            pre = cur;
            cur = node;
            n--;
            if (n == 0) {
                pre = pre.next;
                cur = cur.next;
                n = k;
            }
        }
        return pre;
    }
}
