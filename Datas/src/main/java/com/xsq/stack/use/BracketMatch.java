package com.xsq.stack.use;

import com.xsq.stack.MyArrayStack;

/*
 * 检测表达式中括弧是否匹配
 * */
public class BracketMatch {
    public static void main(String[] args) {
        System.out.println(bracketMatch1("([{}])"));
        System.out.println(bracketMatch1("{[(1+2)*3]+1}"));
        System.out.println(bracketMatch1("{[(10]}"));
    }

    //检测expression表达式中的括弧是否匹配
    public static boolean bracketMatch1(String expression) {
        MyArrayStack stack = new MyArrayStack();
        //遍历整个表达式，如果是左括弧就入栈，如果是右括弧，就出栈进行判断是否匹配
        for (int i = 0; i < expression.length(); i++) {
            char cc = expression.charAt(i);
            switch (cc) {
                case '(':
                case '[':
                case '{':
                    stack.push(cc);  //左括弧入栈，java可以自动装箱与拆箱
                    break;
                case '}':
                    if (!stack.isEmpty() && stack.pop().equals('{')) {
                        break;
                    } else {
                        return false;
                    }
                case ']':
                    if (!stack.isEmpty() && stack.pop().equals('[')) {
                        break;
                    } else {
                        return false;
                    }
                case ')':
                    if (!stack.isEmpty() && stack.pop().equals('(')) {
                        break;
                    } else {
                        return false;
                    }
            }
        }
        //表达式遍历完后，如果栈是空的，表示括弧匹配
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
