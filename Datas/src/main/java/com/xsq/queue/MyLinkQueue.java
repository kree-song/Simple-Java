package com.xsq.queue;

/*
 * 队列的链式存储(通过单向链表实现)
 * */
public class MyLinkQueue {
    private Node front;//队首
    private Node rear;//队尾
    private int size;//元素的个数

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //入队
    public void enQueue(Object e) {
        //根据添加的元素生成一个结点
        Node newNode = new Node(e, null);
        //把结点连接到队列中
        if (rear == null) {
            //这是添加的第一个元素，既是头结点也是尾结点
            rear = newNode;
            front = newNode;
        } else {
            //把结点链拉到队列的尾部
            rear.next = newNode;
            rear = newNode;   //rear指针指向新添加的元素
        }
        size++;
    }

    //出队
    public Object deQueue() {
        //判断队列是否为空
        if (size <= 0) {
            throw new QueueEmptyException("队列为空");
        }
        Object old = front.element;
        front = front.next;  //调整队首指针
        //如果出队后，队列为空，调整尾指针
        if (front == null) {
            rear = null;
        }
        size--;
        return old;
    }

    public Object peek() {
        //判断队列是否为空
        if (size <= 0) {
            throw new QueueEmptyException("队列为空");
        }
        return front.element;
    }

    //通过内部类表示单向链表的结点
    private class Node {
        Object element;
        Node next;

        public Node(Object element, Node next) {
            this.element = element;
            this.next = next;
        }
    }
}
