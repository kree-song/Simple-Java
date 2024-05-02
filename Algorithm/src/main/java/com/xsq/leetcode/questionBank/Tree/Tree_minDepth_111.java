package com.xsq.leetcode.questionBank.Tree;

import com.xsq.leetcode.Node.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Tree_minDepth_111 {
    public static void main(String[] args) {
//        TreeNode_ node7=new TreeNode_(7,null,null);
//        TreeNode_ node6=new TreeNode_(6,node7,null);
//        TreeNode_ node5=new TreeNode_(5,null,null);
//        TreeNode_ node4=new TreeNode_(4,null,null);
//        TreeNode_ node3=new TreeNode_(3,node6,null);
//        TreeNode_ node2=new TreeNode_(2,node4,node5);
//        TreeNode_ node1=new TreeNode_(1,node2,node3);

        //广度优先用val存储深度
        TreeNode node7 = new TreeNode(0, null, null);
        TreeNode node6 = new TreeNode(0, node7, null);
        TreeNode node5 = new TreeNode(0, null, null);
        TreeNode node4 = new TreeNode(0, null, null);
        TreeNode node3 = new TreeNode(0, node6, null);
        TreeNode node2 = new TreeNode(0, node4, node5);
        TreeNode node1 = new TreeNode(0, node2, node3);
        System.out.println(minDepth2(node1));
    }

    //深度优先
    public static int minDepth(TreeNode root) {
        //空结点
        if (root == null) {
            return 0;
        }
        //叶子结点
        if (root.left == null && root.right == null) {
            return 1;
        }

        //递归求最小
        int min = Integer.MAX_VALUE;
        if (root.left != null) {
            min = Math.min(minDepth(root.left), min);
        }
        if (root.right != null) {
            min = Math.min(minDepth(root.right), min);
        }

        return min + 1;
    }

    //广度优先
    public static int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        root.val = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            //从左往右第一个叶子结点的深度即为最小深度
            if (node.left == null && node.right == null) {
                return node.val;
            }
            if (node.left != null) {
                node.left.val = node.val + 1;
                queue.offer(node.left);
            }
            if (node.right != null) {
                node.right.val = node.val + 1;
                queue.offer(node.right);
            }
        }
        return 0;//不可能到此
    }
}
