package com.xsq.leetcode.questionBank.Queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 2810.故障键盘
 * 你的笔记本键盘存在故障，每当你在上面输入字符 'i' 时，它会反转你所写的字符串。而输入其他字符则可以正常工作
 * 给你一个下标从0开始的字符串，请你用故障键盘依次输入每个字符。返回最终笔记本屏幕上输出的字符串
 */
public class Queue_FinalString_2810 {
    public static void main(String[] args) {
        System.out.println(finalString("string"));
    }


    /**
     * 双端队列
     * 当字符串进行反转后，在末尾添加字符等价于「不对字符串进行反转，并且在开头添加字符」
     * O(n),O(n)
     */
    public static String finalString(String s) {
        Deque<Character> q = new ArrayDeque<Character>();
        boolean flag = false;
        for (int i = 0;i < s.length();i++) {
            char ch = s.charAt(i);
            if (ch != 'i') {
                if (flag) {
                    q.offerFirst(ch);
                } else {
                    q.offerLast(ch);
                }
            } else {
                flag = !flag;
            }
        }

        StringBuilder ans = new StringBuilder();
        if (flag) {
            while (!q.isEmpty()) {
                ans.append(q.pollLast());
            }
        } else {
            while (!q.isEmpty()) {
                ans.append(q.pollFirst());
            }
        }
        return ans.toString();
    }
}
