package com.xsq._2stack;

/*
 * 堆栈的顺序实现(借助数组)
 * */
public class MyArrayStack implements MyStack {
    private static final int DEFAULT_CAPACITY = 16; //堆栈的默认容量
    private Object[] elements;   //定义数组保存堆栈元素
    private int top;   //堆栈指针

    //构造方法
    //在无参构造中，对数组默认初始化
    public MyArrayStack() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    //在有参构造中，指定堆栈的初始化大小
    public MyArrayStack(int initialCapacity) {
        elements = new Object[initialCapacity];
    }

    //成员方法
    @Override
    public int getSize() {
        return top;
    }

    @Override
    public boolean isEmpty() {
        return top <= 0;
    }

    //入栈、压栈
    @Override
    public void push(Object e) {
        //判断堆栈是否已满，如果堆栈已满，数组需要扩容
        if (top >= elements.length) {
            //定义一个更大的数组，默认按2倍扩容
            Object[] newData = new Object[elements.length * 2];
            //把原来的数组内容复制到大的数组
            for (int i = 0; i < elements.length; i++) {
                newData[i] = elements[i];
            }
            //让原来的数组名指向新的数组
            elements = newData;
        }
        //把元素存储到栈顶指针指向的位置
        elements[top] = e;
        //栈顶指针上移
        top++;
    }

    @Override
    public Object pop() {
        //判断堆栈是否为空
        if (top <= 0) {
            throw new StackOverflowError("栈已空");
        }
        top--;//栈底指针下移
        return elements[top];
    }

    //返回栈顶元素，不删除
    @Override
    public Object peek() {
        //判断堆栈是否为空
        if (top <= 0) {
            throw new StackOverflowError("栈已空");
        }
        return elements[top - 1];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        //从栈顶到栈底的顺序依次添加各个元素
        for (int i = top - 1; i >= 0; i--) {
            sb.append(elements[i]);
            if (i > 0) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
