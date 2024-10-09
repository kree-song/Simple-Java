package com.xsq._2stack.algo;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class StackAPI {
    public static void main(String[] args) {
        LinkedList<Integer> linkedListStack = new LinkedList<>();//方法1
        linkedListStack.addLast(1);   // 元素 1 入栈
        linkedListStack.addLast(2);   // 元素 2 入栈
        linkedListStack.removeLast(); // 出栈 -> 元素 2
        linkedListStack.removeLast(); // 出栈 -> 元素 1

        /* 初始化栈 */
        Stack<Integer> stack = new Stack<>();//方法2
        Deque<Character> dequeStack = new LinkedList<>();//方法3

        /* 元素入栈 */
        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.push(5);
        stack.push(4);

        /* 访问栈顶元素 */
        int peek = stack.peek();

        /* 元素出栈 */
        int pop = stack.pop();

        /* 获取栈的长度 */
        int size = stack.size();

        /* 判断是否为空 */
        boolean isEmpty = stack.isEmpty();
    }
}
