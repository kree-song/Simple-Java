package com.xsq.leetcode.questionBank.Stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 331.验证二叉树的前序序列化
 * 序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如#
 */
public class Stack_IsValidSerialization_331 {
    public static void main(String[] args) {
        String preOrder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        System.out.println(isValidSerialization(preOrder));
    }

    /**
     * 栈
     * 二叉树的建立也伴随着槽位数量的变化。如果遇到了空节点，则要消耗一个槽位；如果遇到了非空节点，则除了消耗一个槽位外，还要再补充两个槽位。
     * 栈中的每个元素，代表了对应节点处剩余槽位的数量，而栈顶元素就对应着下一步可用的槽位数量。
     *    当遇到空节点时，仅将栈顶元素减1；当遇到非空节点时，将栈顶元素减1后，再向栈中压入一个2。无论何时，如果栈顶元素变为0，就立刻将栈顶弹出。
     *    遍历结束后，若栈为空，说明没有待填充的槽位，因此是一个合法序列；否则若栈不为空，则序列不合法。此外，在遍历的过程中，若槽位数量不足，则序列不合法
     * O(n),O(n)
     */
    public static boolean isValidSerialization(String preorder) {
        int n = preorder.length();
        int i = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(1);
        while (i < n){
            if (stack.isEmpty()) return false;
            if (preorder.charAt(i) == ',') {
                i++;
            } else if (preorder.charAt(i) == '#') {
                int top = stack.pop() - 1;
                if (top > 0) {
                    stack.push(top);
                }
                i++;
            } else {
                //为数字
                while (i < n && preorder.charAt(i) != ',') {
                    i++;
                }
                int top = stack.pop() - 1;
                if (top > 0) {
                    stack.push(top);
                }
                stack.push(2);
            }
        }
        return stack.isEmpty();
    }

    /**
     * 使用计数器，使得空间复杂度变为O(1)
     */
    public static boolean isValidSerialization2(String preorder) {
        int n = preorder.length();
        int i = 0;
        int counter = 1;
        while (i < n) {
            if (counter == 0) return false;
            if (preorder.charAt(i) == ',') {
                i++;
            } else if (preorder.charAt(i) == '#') {
                counter--;
                i++;
            } else {
                //为数字
                while (i < n && preorder.charAt(i) != ',') {
                    i++;
                }
                counter++; //counter - 1 + 2
            }
        }
        return counter == 0;
    }
}
