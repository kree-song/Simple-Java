package com.xsq.queue;

public interface MyQueue {
    public int getSize();

    public boolean isEmpty();

    public void enQueue(Object e);

    public Object deQueue();

    public Object peek();
}
