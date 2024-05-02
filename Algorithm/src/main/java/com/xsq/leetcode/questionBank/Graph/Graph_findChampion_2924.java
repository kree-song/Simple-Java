package com.xsq.leetcode.questionBank.Graph;

/**
 * 2924.找到冠军 II
 * 一场比赛中共有 n 支队伍，按从 0 到  n - 1 编号。每支队伍也是 有向无环图（DAG） 上的一个节点。
 * 给你一个整数 n 和一个下标从 0 开始、长度为 m 的二维整数数组 edges 表示这个有向无环图，其中 edges[i] = [ui, vi] 表示图中存在一条从 ui 队到 vi 队的有向边。
 * 从 a 队到 b 队的有向边意味着 a 队比 b 队 强 ，也就是 b 队比 a 队 弱 。
 * 在这场比赛中，如果不存在某支强于 a 队的队伍，则认为 a 队将会是 冠军 。
 * 如果这场比赛存在 唯一 一个冠军，则返回将会成为冠军的队伍。否则，返回 -1 。
 */
public class Graph_findChampion_2924 {
    public static void main(String[] args) {
        int[][] edges = new int[][]{{0,1},{1,2}};
        System.out.println(findChampion(3,edges));
        int[][] edges2 = new int[][]{{0,2},{1,3},{1,2}};
        System.out.println(findChampion(4,edges2));
        int[][] edges3 = new int[][]{};
        System.out.println(findChampion(1,edges3));

    }

    /**
     * 找出入度为0的唯一点即可
     */
    public static int findChampion(int n, int[][] edges) {
        int[] degree = new int[n];
        for (int[] e : edges) {
            degree[e[1]]++;
        }
        //tips 第一次degree[i]==0时将champion设置为下标，若再次为0则直接返回
        int champion = -1;
        for (int i = 0; i < n; i++) {
            if (degree[i] == 0) {
                if (champion == -1) {
                    champion = i;//判别重复值
                } else {
                    return -1;
                }
            }
        }
        return champion;
    }
}
