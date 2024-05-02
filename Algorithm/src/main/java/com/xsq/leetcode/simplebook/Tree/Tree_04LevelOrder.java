package com.xsq.leetcode.simplebook.Tree;

import com.xsq.leetcode.Node.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * 二叉树的层序遍历
 * 给你二叉树的根节点root，返回其节点值的 层序遍历。（即逐层地，从左到右访问所有节点）
 * */
public class Tree_04LevelOrder {
    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(7, null, null);
        TreeNode node4 = new TreeNode(15, null, null);
        TreeNode node3 = new TreeNode(20, node4, node5);
        TreeNode node2 = new TreeNode(9, null, null);
        TreeNode node1 = new TreeNode(3, node2, node3);
        System.out.println(levelOrder(node1));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

//        List<Integer> list=new ArrayList<>();
//        int count=1;
//        int sum=0;
//        while (count>0){
//            TreeNode_ node=queue.poll();
//            list.add(node.val);
//            count--;
//            if(node.left!=null){
//                queue.offer(node.left);
//                sum++;
//            }
//            if(node.right!=null){
//                queue.offer(node.right);
//                sum++;
//            }
//            if(count==0){
//                count=sum;
//                sum=0;
//                lists.add(list);
//                list=new ArrayList<>();
//            }
//        }

        //优化
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();//！！！把List<Integer> list放在循环外可显著减少内存使用，但时间消耗更大
            int currentsize = queue.size();//记录最新一层的队列大小
            for (int i = 0; i < currentsize; i++) {//该进的进，该出的出
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            lists.add(list);//把这一层的数据加进去
        }
        return lists;
    }
}
