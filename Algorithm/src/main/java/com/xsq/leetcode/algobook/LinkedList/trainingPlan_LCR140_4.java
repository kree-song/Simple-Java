package src.com.xsq.leetcode.algobook.LinkedList;

import com.xsq.leetcode.Node.ListNode;

/**
 * LCR140.训练计划 II
 * 给定一个头节点为 head 的链表用于记录一系列核心肌群训练项目编号，请查找并返回倒数第 cnt 个训练项目编号
 */
public class trainingPlan_LCR140_4 {
    public static void main(String[] args) {

    }

    /**
     * 双指针
     * O(n)、O(1)
     */
    public ListNode trainingPlan(ListNode head, int cnt) {
        ListNode left = head,right = head;
        while (cnt != 0) {
            right = right.next;
            cnt--;
        }
        while (right != null) {
            left = left.next;
            right = right.next;
        }
        return left;
    }
}
