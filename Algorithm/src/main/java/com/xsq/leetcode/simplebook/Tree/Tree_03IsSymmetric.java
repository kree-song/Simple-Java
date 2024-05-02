package com.xsq.leetcode.simplebook.Tree;

import com.xsq.leetcode.Node.TreeNode;

/*
 * 对称二叉树
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称
 * */
public class Tree_03IsSymmetric {
    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(3, null, null);
        TreeNode node6 = new TreeNode(4, null, null);
        TreeNode node5 = new TreeNode(4, null, null);
        TreeNode node4 = new TreeNode(3, null, null);
        TreeNode node3 = new TreeNode(2, node6, node7);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node1 = new TreeNode(1, node2, node3);
        System.out.println(isSymmetric(node1));
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        //从两个子节点开始判断
        return isSymmetricHelper(root.left, root.right);
    }

    public static boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        //若为叶子结点，返回true
        if (left == null && right == null) {
            return true;
        }
        //任一结点为空或都不为空但值不同即不为对称树
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        //递归比较 左子节点的左子节点和右子节点的右子节点比较，左子节点的右子节点和右子节点的左子节点
        return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
    }
}
