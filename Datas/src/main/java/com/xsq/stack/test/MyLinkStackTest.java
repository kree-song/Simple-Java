package com.xsq.stack.test;

import com.xsq.stack.MyLinkStack;

public class MyLinkStackTest {
    public static void main(String[] args) {
        MyLinkStack stack = new MyLinkStack();
        System.out.println(stack.getSize());
        System.out.println(stack.isEmpty());

        stack.push("aa");
        stack.push("bb");
        stack.push("cc");
        stack.push("dd");
        System.out.println(stack);

        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack);
    }
}
