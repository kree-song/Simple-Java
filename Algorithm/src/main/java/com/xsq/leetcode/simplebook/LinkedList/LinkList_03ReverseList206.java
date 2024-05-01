package src.com.xsq.leetcode.simplebook.LinkedList;

import com.xsq.leetcode.Node.ListNode;

/**
 * 206.反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表
 */
public class LinkList_03ReverseList206 {
    public static void main(String[] args) {

    }

    //迭代
    public static ListNode reverseList1(ListNode head) {
        ListNode prev = null;//前驱结点
        ListNode curr = head;//当前结点
        while (curr != null) {
            ListNode next = curr.next;//暂存当前结点的后一结点，防止下一步之后找不到
            curr.next = prev;//断当前链，并指向前一个结点
            prev = curr;//前移
            curr = next;//前移
        }
        return prev;//此时prev是表头
    }

    //递归
    public static ListNode reverseList2(ListNode head) {
        //递归终止条件
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList2(head.next);//递
        head.next.next = head;//归
        head.next = null;
        return p;
    }

    //冒泡递归
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;//若为空，node.next会NullPointer
        }

        int count = 0;
        ListNode node = head;
        while (node.next != null) {//求长度
            node = node.next;
            count++;
        }
        while (count > 0) {//控制对换次数
            reverseListHepler(head, count);
            count--;
        }
        return head;
    }

    //count次对换，使得结点值反转
    public static ListNode reverseListHepler(ListNode head, int count) {
        while (head.next != null && count > 0) {
            int val = head.val;
            head.val = head.next.val;
            head.next.val = val;
            head = head.next;
            count--;
        }
        return head;
    }
}
