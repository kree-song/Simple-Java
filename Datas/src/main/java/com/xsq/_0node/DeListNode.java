package com.xsq._0node;

/**
 * 双向链表节点
 */
public class DeListNode {
    public int val; // 节点值
    public DeListNode next; // 后继节点引用
    public DeListNode prev; // 前驱节点引用

    public DeListNode(int val) {
        this.val = val;
        prev = next = null;
    }
}
