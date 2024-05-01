package com.xsq.tree.binarytree;

import java.util.LinkedList;

/*
 * 使用三叉链表创建二叉树
 * */
public class MyBinaryTree {
    private BinaryTreeNode root;     //二叉树的根结点

    //构造方法
    public MyBinaryTree(BinaryTreeNode root) {
        super();
        this.root = root;
    }


    //成员函数
    public int getSize() {
        if (root == null) {    //空树
            return 0;
        }
        return root.getSize();
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    //返回根结点
    public BinaryTreeNode getRoot() {
        if (root != null) {
            return root;
        }
        return null;
    }

    //返回树的高度
    public int getHeight() {
        if (root == null) {
            return 0;
        }
        return root.getHeight();
    }


    //二叉树先序遍历
    //先序遍历二叉树，把遍历的结点存储到List列表中
    private void preOrderRecursion(BinaryTreeNode root, LinkedList<Object> list) {
        if (root == null) {
            return;           //空树
        }
        //先访问根结点，把根结点存储到列表中
        list.add(root.getData());
        //递归，先序遍历左子树
        preOrderRecursion(root.getLChild(), list);
        //递归，先序遍历右子树
        preOrderRecursion(root.getRChild(), list);
    }

    //打印当前二叉树的先序遍历序列
    public void preOrder() {
        LinkedList<Object> list = new LinkedList<>();
        preOrderRecursion(root, list);
        System.out.println(list);
    }


    //二叉树中序遍历
    //中序遍历二叉树，把遍历的结点存储到List列表中
    private void inOrderRecursion(BinaryTreeNode root, LinkedList<Object> list) {
        if (root == null) {
            return;           //空树
        }
        //递归，中序遍历左子树
        inOrderRecursion(root.getLChild(), list);
        //访问根结点，把根结点存储到列表中
        list.add(root.getData());
        //递归，中序遍历右子树
        inOrderRecursion(root.getRChild(), list);
    }

    //打印当前二叉树的中序遍历序列
    public void inOrder() {
        LinkedList<Object> list = new LinkedList<>();
        inOrderRecursion(root, list);
        System.out.println(list);
    }


    //二叉树后序遍历
    //后序遍历二叉树，把遍历的结点存储到List列表中
    private void postOrderRecursion(BinaryTreeNode root, LinkedList<Object> list) {
        if (root == null) {
            return;           //空树
        }
        //递归，后序遍历左子树
        postOrderRecursion(root.getLChild(), list);
        //递归，后序遍历右子树
        postOrderRecursion(root.getRChild(), list);
        //访问根结点，把根结点存储到列表中
        list.add(root.getData());
    }

    //打印当前二叉树的后序遍历序列
    public void postOrder() {
        LinkedList<Object> list = new LinkedList<>();
        postOrderRecursion(root, list);
        System.out.println(list);
    }


    //二叉树层次遍历
    public void levelOrderTraverse(BinaryTreeNode root, LinkedList<Object> list) {
        if (root == null) {
            return;           //空树
        }
        //定义一个队列，存储结点，作为中间容器
        LinkedList<BinaryTreeNode> queue = new LinkedList<>();//java中用链表表示队列
        queue.offer(root);    //根结点入队
        while (!queue.isEmpty()) {
            //把队列头部的结点取出来
            BinaryTreeNode node = queue.poll(); //出队
            //把结点的数据添加到list列表中
            list.add(node.getData());
            //分别把node的左结点与右结点入队
            if (node.hasLChild()) {
                queue.offer(node.getLChild());
            }
            if (node.hasRChild()) {
                queue.offer(node.getRChild());
            }
        }
    }

    public void levelOrder() {
        LinkedList<Object> list = new LinkedList<>();
        levelOrderTraverse(root, list);
        System.out.println(list);
    }
}
