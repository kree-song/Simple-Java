package com.xsq.leetcode.simplebook.Tree;

import com.xsq.leetcode.Node.TreeNode;

/*
 *  验证二叉搜索树
 *  给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *  有效二叉搜索树定义如下：
 *     节点的左子树只包含 小于 当前节点的数。
 *     节点的右子树只包含 大于 当前节点的数。
 *     所有左子树和右子树自身必须也是二叉搜索树
 * */
public class Tree_02IsValidBST {
    public static void main(String[] args) {

    }

    public static boolean isValidBST(TreeNode root) {
//        if(root==null){
//            return true;
//        }
//        if(root.left!=null&&root.left.val>=root.val){
//            return false;
//        }
//        if(root.right!=null&&root.right.val<=root.val){
//            return false;
//        }
//        isValidBST(root.left);
//        isValidBST(root.right);
//        return true;
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isValidBSTHelper(TreeNode root, Long min, Long max) {
        if (root == null) {
            return true;
        }
        if (root.val >= max || root.val <= min) {
            return false;
        }
        return isValidBSTHelper(root.left, min, (long) root.val) && isValidBSTHelper(root.right, (long) root.val, max);
    }
}
