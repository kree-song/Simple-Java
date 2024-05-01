package src.com.xsq.leetcode.questionBank.Map;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 2192.有向无环图中一个节点的所有祖先
 * 给你一个正整数 n ，它表示一个 有向无环图 中节点的数目，节点编号为 0 到 n - 1 （包括两者）
 * 给你一个二维整数数组 edges ，其中 edges[i] = [fromi, toi] 表示图中一条从 fromi 到 toi 的单向边
 * 请你返回一个数组 answer，其中 answer[i]是第 i 个节点的所有 祖先 ，这些祖先节点 升序 排序
 * 如果 u 通过一系列边，能够到达 v ，那么我们称节点 u 是节点 v 的 祖先 节点
 *
 * 如何顺序创建List中的List？List<List<Integer>> ans = new ArrayList<>(Collections.nCopies(n,new ArrayList<>()));
 */
public class Map_getAncestors_2192 {
    public static void main(String[] args) {
        System.out.println(getAncestors(8,new int[][]{{0,3},{0,4},{1,3},{2,4},{2,7},{3,5},{3,6},{3,7},{4,6}}));//[[],[],[],[0,1],[0,2],[0,1,3],[0,1,2,3,4],[0,1,2,3]]
        System.out.println(getAncestors(5,new int[][]{{0,1},{0,2},{0,3},{0,4},{1,2},{1,3},{1,4},{2,3},{2,4},{3,4}}));//[[],[0],[0,1],[0,1,2],[0,1,2,3]]
    }

    /**
     * MLE
     */
    public static List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> ans = new ArrayList<>(n);
        for (int i = 0;i < n;i++) {
            ans.add(new ArrayList<>());
        }

        ArrayList<Integer> over = new ArrayList<>(n);//已经找到所有ancestors的结点
        for (int[] edge : edges) {
            //找出直接相连的祖先
            ans.get(edge[1]).add(edge[0]);
        }
        for (int i = 0;i < ans.size();i++) {
            if (ans.get(i).size() == 0) {
                //找出入度为0的结点
                over.add(i);
            }
        }

        while (over.size() != n){
            for (int i = 0;i < ans.size();i++) {
                if (over.contains(i)) continue;
                //若新结点的所有ancestor均已找到其所有ancestor，则加入其间接ancestor
                List<Integer> list = ans.get(i);
                ArrayList<Integer> addList = new ArrayList();
                if (over.containsAll(list)) {
                    for (int j : list) {
                        if (ans.get(j).size() != 0) {
                            addList.addAll(ans.get(j));
                        }
                    }
                    over.add(i);
                }
                ans.get(i).addAll(addList);
            }
        }

        for (int i = 0; i < n; i++) {
            ans.set(i,ans.get(i).stream().distinct().sorted().collect(Collectors.toList()));
        }

        return ans;
    }

    /**
     * 拓扑排序
     * O(VE+V^2logV)，其中V=n为节点数量；E为边的数量，即 edges 的长度。其中广度优先搜索的时间复杂度为 O(VE)，对辅助数组排序生成答案数组的时间复杂度为 O(V2logV)
     * O(V^2)，即为存储每个节点祖先的辅助数组的空间开销
     */
    public static List<List<Integer>> getAncestors2(int n, int[][] edges) {
        Set<Integer>[] anc = new Set[n]; //存储每个结点祖先的辅助数组
        for (int i = 0; i < n; i++) {
            anc[i] = new HashSet<Integer>();
        }
        List<Integer>[] e = new List[n]; //邻接表
        for (int i = 0; i < n; i++) {
            e[i] = new ArrayList<Integer>();
        }
        int[] inDegree = new int[n]; //入度表
        //预处理
        for (int[] edge : edges) {
            e[edge[0]].add(edge[1]);
            ++inDegree[edge[1]];
        }
        //广度优先搜索求解拓扑排序
        Queue<Integer> queue = new ArrayDeque<Integer>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : e[u]) {
                //对于每一个与u相邻接的结点v，向v的ancestors中加入u及u的ancestors
                anc[v].add(u);
                for (int i : anc[u]) {
                    anc[v].add(i);
                }
                //将v的入度-1，当v的入度减为0时，加入queue
                --inDegree[v];
                if (inDegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            ans.add(new ArrayList<Integer>());
            for (int j : anc[i]) {
                ans.get(i).add(j);
            }
            Collections.sort(ans.get(i));
        }
        return ans;
    }
}
