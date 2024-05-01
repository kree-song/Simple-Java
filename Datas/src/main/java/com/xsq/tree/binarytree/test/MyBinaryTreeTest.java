package com.xsq.tree.binarytree.test;

import com.xsq.tree.binarytree.BinaryTreeNode;
import com.xsq.tree.binarytree.MyBinaryTree;

/*
 * 测试二叉树的遍历序列
 * */
public class MyBinaryTreeTest {
    public static void main(String[] args) {
        //创建根结点
        BinaryTreeNode root = new BinaryTreeNode("oo");

        //创建两个结点设置为root的左孩子和右孩子
        BinaryTreeNode xx = new BinaryTreeNode("xx");
        BinaryTreeNode yy = new BinaryTreeNode("yy");
        root.setLChild(xx);
        root.setRChild(yy);

        //创建两个结点，作为xx的左孩子和右孩子
        BinaryTreeNode xl = new BinaryTreeNode("xll");
        BinaryTreeNode xr = new BinaryTreeNode("xrr");
        xx.setLChild(xl);
        xx.setRChild(xr);

        //创建一个结点作为yy结点的右孩子
        BinaryTreeNode yr = new BinaryTreeNode("yrr");
        yy.setRChild(yr);

        //创建二叉树
        MyBinaryTree tree = new MyBinaryTree(root);
        //先序遍历
        tree.preOrder();//[oo, xx, xll, xrr, yy, yrr]
        //中序遍历
        tree.inOrder();//[xll, xx, xrr, oo, yy, yrr]
        //后序遍历
        tree.postOrder();//[xll, xrr, xx, yrr, yy, oo]
        //层次遍历
        tree.levelOrder();//[oo, xx, yy, xll, xrr, yrr]
    }
}
