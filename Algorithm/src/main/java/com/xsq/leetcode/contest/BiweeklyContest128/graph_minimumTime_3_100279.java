package com.xsq.leetcode.contest.BiweeklyContest128;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 100279.访问消失节点的最少时间
 * 给你一个二维数组 edges 表示一个 n 个点的无向图，其中 edges[i] = [ui, vi, lengthi] 表示节点 ui 和节点 vi 之间有一条需要 lengthi 单位时间通过的无向边。
 * 同时给你一个数组 disappear ，其中 disappear[i] 表示节点 i 从图中消失的时间点，在那一刻及以后，你无法再访问这个节点。
 * 注意，图有可能一开始是不连通的，两个节点之间也可能有多条边。
 * 请你返回数组 answer ，answer[i] 表示从节点 0 到节点 i 需要的 最少 单位时间。如果从节点 0 出发 无法 到达节点 i ，那么 answer[i] 为 -1 。
 */
public class graph_minimumTime_3_100279 {
    public static void main(String[] args) {
        int[][] edges = new int[][]{{0,1,2},{1,2,1},{0,2,4}};
        int[] disappear = {1,1,5};
        System.out.println(Arrays.toString(minimumTime(3, edges, disappear)));//[0,-1,4]
        int[][] edges2 = new int[][]{{0,1,2},{1,2,1},{0,2,4}};
        int[] disappear2 = {1,3,5};
        System.out.println(Arrays.toString(minimumTime(3, edges2, disappear2)));//[0,2,3]
        int[][] edges3 = new int[][]{{0,1,1}};
        int[] disappear3 = {1,1};
        System.out.println(Arrays.toString(minimumTime(2, edges3, disappear3)));//[0,-1]
        int[][] edges4 = new int[][]{{4,0,5},{3,7,3},{0,2,3},{3,5,3},{7,0,1},{2,0,3},{7,7,10}};
        int[] disappear4 = {15,8,4,3,9,18,9,13};
        System.out.println(Arrays.toString(minimumTime(8, edges4, disappear4)));//[0,-1,3,-1,5,-1,-1,1]
        int[][] edges5 = new int[][]{{0,3,10},{2,3,2},{3,3,6},{3,3,9},{1,3,2},{3,0,4}};
        int[] disappear5 = {17,17,17,8,20};
        System.out.println(Arrays.toString(minimumTime(5, edges5, disappear5)));//[0,6,6,4,-1]
    }

    /**
     * Dijkstra
     */
    public static int[] minimumTime(int n, int[][] edges, int[] disappear) {
        List<int[]>[] g = new ArrayList[n]; // 稀疏图用邻接表
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            int x = e[0];
            int y = e[1];
            int wt = e[2];
            g[x].add(new int[]{y, wt});
            g[y].add(new int[]{x, wt});
        }

        int[] dis = new int[n];
        Arrays.fill(dis, -1);
        dis[0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        pq.offer(new int[]{0, 0});//目前到j点的最短距离i
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int dx = p[0];
            int x = p[1];
            if (dx > dis[x]) { // x 之前出堆过
                continue;
            }
            for (int[] e : g[x]) {
                int y = e[0];
                int newDis = dx + e[1];
                if (newDis < disappear[y] && (dis[y] < 0 || newDis < dis[y])) {
                    dis[y] = newDis; // 更新 x 的邻居的最短路
                    pq.offer(new int[]{newDis, y});//若更新了y点的距离，则必须重新遍历其邻点
                }
            }
        }
        return dis;
    }

    /**
     * 严重依赖先后顺序，edges5用例过不了
     */
    public static int[] minimumTime2(int n, int[][] edges, int[] disappear) {
        int[] time = new int[n];
        Arrays.fill(time,1, n,100000);

        for (int i = 1; i < n; i++) {
            for (int[] edge : edges) {
                //直接抵达
                if (((edge[0] == 0 && edge[1] == i) || (edge[0] == i && edge[1] == 0)) && edge[2] < time[i]) {//考虑双方向
                    time[i] = edge[2];
                }
                //间接抵达
                if (edge[0] != 0 && edge[1] == i && time[edge[0]] < disappear[edge[0]] && time[edge[0]] + edge[2]< time[i]) {
                    time[i] = time[edge[0]] + edge[2];
                } else if (edge[0] == i && edge[1] != 0 && time[edge[1]] < disappear[edge[1]] && time[edge[1]] + edge[2]< time[i]) {
                    time[i] = time[edge[1]] + edge[2];
                }
            }
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = time[i] < disappear[i] ? time[i] : -1;
        }
        return res;
    }
}
