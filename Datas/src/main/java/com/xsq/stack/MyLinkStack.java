package com.xsq.stack;

/*
 * 栈的链式存储
 * */
public class MyLinkStack implements MyStack {
    private Node top;//存储栈顶的引用
    private int size;//保存堆栈中元素的个数

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void push(Object e) {
        //根据元素生成结点，插入到链表的头部
        Node pNode = new Node(e, top);
        //修改top栈顶指针指向新的结点
        top = pNode;
        size++;
    }

    @Override
    public Object pop() {
        if (size < 1) {
            throw new StackOverflowError("栈已空");
        }
        Object oldData = top.data;
        top = top.next;//栈顶指针后移
        size--;
        return oldData;
    }

    @Override
    public Object peek() {
        if (size < 1) {
            throw new StackOverflowError("栈已空");
        }
        return top.data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Node pNode = top; pNode != null; pNode = pNode.next) {
            sb.append(pNode.data);
            if (pNode.next != null) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    //定义一个内部类，描述链表中的结点
    private class Node {
        Object data;//存储数据
        Node next;//存储下一个结点的引用

        public Node(Object data, Node next) {
            super();
            this.data = data;
            this.next = next;
        }
    }
}
