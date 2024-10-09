package com.xsq._3queue.test;

import com.xsq._3queue.MyArrayQueue;

/*
 * 测试顺序存储的队列
 * */
public class MyArrayQueueTest {
    public static void main(String[] args) {
        MyArrayQueue queue = new MyArrayQueue();

        queue.enQueue("a");
        queue.enQueue("b");
        queue.enQueue("c");
        queue.enQueue("d");
        System.out.println(queue.peek());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        //System.out.println(queue.deQueue());

        queue.enQueue("1");
        queue.enQueue("2");
        queue.enQueue("3");
        queue.enQueue("4");
        queue.enQueue("5");
        queue.enQueue("6");
        queue.enQueue("7");
        queue.enQueue("8");
        queue.enQueue("9");
        queue.enQueue("J");
        queue.enQueue("Q");
        queue.enQueue("K");
        queue.enQueue("A");
        System.out.println(queue.deQueue());
        ;


    }
}
