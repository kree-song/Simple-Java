package com.xsq._3queue;

/*
 * 队列的顺序存储实现
 * */
public class MyArrayQueue {
    private static final int DEFAULT_CAPACITY = 8;
    private Object[] elements;   //定义数组存储队列中的元素
    private int front;//队首
    private int rear;//队尾
    private int size;//元素的个数

    //构造方法
    public MyArrayQueue() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayQueue(int initialCapacity) {
        elements = new Object[initialCapacity];
    }

    //成员函数
    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //入队
    public void enQueue(Object e) {
        //如果队列已满，可以对数组扩容
        if (size >= elements.length) {
            expandQueue();
        }

        elements[rear] = e;          //把元素存储到rear指针指向的单元
        rear = (rear + 1) % elements.length; //rear指针后移
        size++;
    }

    //队列的数组进行扩容
    public void expandQueue() {
        //定义一个更大的数组
        Object[] newElements = new Object[elements.length * 2];//默认2倍扩容
        //把原来数组的内容复制到新的数组中，从队首开始的元素依次复制到新数组索引值开始的位置
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[front];
            front = (front + 1) % elements.length;
        }
        //把原来的数组名指向新的数组
        elements = newElements;
        //调整新的队首队尾指针
        front = 0;
        rear = size;
    }

    //出队
    public Object deQueue() {
        //队列为空
        if (size <= 0) {
            //抛出队列为空的异常
            throw new QueueEmptyException("队列为空");
        }
        //队列不为空，把front指向的元素返回
        Object old = elements[front];
        front = (front + 1) % elements.length;  //front指针后移
        size--;
        return old;
    }

    //返回队首元素
    public Object peek() {
        //队列为空，抛出异常
        if (size <= 0) {
            throw new QueueEmptyException("队列为空");
        }

        return elements[front];
    }

}
