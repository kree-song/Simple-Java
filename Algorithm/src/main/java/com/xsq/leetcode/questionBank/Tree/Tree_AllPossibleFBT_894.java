package com.xsq.leetcode.questionBank.Tree;


import com.xsq.leetcode.Node.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 894.所有可能的真二叉树
 * 给你一个整数n，请你找出所有可能含n个节点的真二叉树，并以列表形式返回。答案中每棵树的每个节点都必须符合Node.val == 0
 * 答案的每个元素都是一棵真二叉树的根节点。你可以按任意顺序返回最终的真二叉树列表。
 * 真二叉树是一类二叉树，树中每个节点恰好有0或2个子节点。
 */
public class Tree_AllPossibleFBT_894 {
    public static void main(String[] args) {

    }

    /**
     * 分治法
     */
    private static List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> fullBinaryTrees = new ArrayList<TreeNode>();
        if (n % 2 == 0) {
            return fullBinaryTrees;
        }
        if (n == 1) {
            fullBinaryTrees.add(new TreeNode(0));
            return fullBinaryTrees;
        }
        for (int i = 1; i < n; i += 2) {
            List<TreeNode> leftSubtrees = allPossibleFBT(i);
            List<TreeNode> rightSubtrees = allPossibleFBT(n - 1 - i);
            for (TreeNode leftSubtree : leftSubtrees) {
                for (TreeNode rightSubtree : rightSubtrees) {
                    TreeNode root = new TreeNode(0, leftSubtree, rightSubtree);
                    fullBinaryTrees.add(root);
                }
            }
        }
        return fullBinaryTrees;
    }
}
