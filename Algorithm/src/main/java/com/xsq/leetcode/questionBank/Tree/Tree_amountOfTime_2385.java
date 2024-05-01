package src.com.xsq.leetcode.questionBank.Tree;

import com.xsq.leetcode.Node.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 2385.感染二叉树需要的总时间
 * 给你一棵二叉树的根节点 root ，二叉树中节点的值 互不相同 。另给你一个整数 start 。在第 0 分钟，感染 将会从值为 start 的节点开始爆发。
 * 每分钟，如果节点满足以下全部条件，就会被感染：
 * 节点此前还没有感染
 * 节点与一个已感染节点相邻
 * 返回感染整棵树需要的分钟数
 */
public class Tree_amountOfTime_2385 {
    public static void main(String[] args) {

    }

    /**
     * 先将树的结构用深度优先搜索解析成无向图，再用广度优先搜索来求最长距离
     * O(n)、O(n)
     */
    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        dfs(graph, root);

        //广度优先搜索求最长距离
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{start, 0});
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        int time = 0;
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int nodeVal = arr[0];
            time = arr[1];
            for (int childVal : graph.get(nodeVal)) {
                if (visited.add(childVal)) {
                    queue.offer(new int[]{childVal, time + 1});
                }
            }
        }
        return time;//最后即为最外层距离
    }

    /**
     * !使用深度优先搜索将树解析成无向图(邻接表表示)
     */
    public void dfs(Map<Integer, List<Integer>> graph, TreeNode node) {
        graph.putIfAbsent(node.val, new ArrayList<>());
        for (TreeNode child : Arrays.asList(node.left,node.right)) {
            if (child != null) {
                graph.get(node.val).add(child.val);
                graph.putIfAbsent(child.val, new ArrayList<>());
                graph.get(child.val).add(node.val);
                dfs(graph, child);
            }
        }
    }


}
