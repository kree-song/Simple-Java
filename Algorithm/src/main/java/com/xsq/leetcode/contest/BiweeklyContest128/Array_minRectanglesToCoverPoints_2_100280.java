package com.xsq.leetcode.contest.BiweeklyContest128;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 100280.覆盖所有点的最少矩形数目
 * 给你一个二维整数数组 point ，其中 points[i] = [xi, yi] 表示二维平面内的一个点。同时给你一个整数 w 。你需要用矩形 覆盖所有 点。
 * 每个矩形的左下角在某个点 (x1, 0) 处，且右上角在某个点 (x2, y2) 处，其中 x1 <= x2 且 y2 >= 0 ，同时对于每个矩形都 必须 满足 x2 - x1 <= w 。
 * 如果一个点在矩形内或者在边上，我们说这个点被矩形覆盖了。
 * 请你在确保每个点都 至少 被一个矩形覆盖的前提下，最少 需要多少个矩形。
 */
public class Array_minRectanglesToCoverPoints_2_100280 {
    public static void main(String[] args) {
        int[][] points = new int[][]{{2,1},{1,0},{1,4},{1,8},{3,5},{4,6}};
        System.out.println(minRectanglesToCoverPoints(points,1));//2
        int[][] points2 = new int[][]{{0,0},{1,1},{2,2},{3,3},{4,4},{5,5},{6,6}};
        System.out.println(minRectanglesToCoverPoints(points2,2));//3
        int[][] points3 = new int[][]{{2,3},{1,2}};
        System.out.println(minRectanglesToCoverPoints(points3,0));//2
    }

    /**
     * 先将题目域转化为横坐标去重集合
     * 以w为窗口向后移动，若Xi大于右边界，则将结果+1且窗口右移。永远保证有一个值在窗口内，最后一个值额外将结果+1
     * O(n),O(n)
     */
    public static int minRectanglesToCoverPoints(int[][] points, int w) {
        //找出所有点的横坐标顺序去重集合
        int n = points.length;
        Set<Integer> set = new HashSet<>(n);
        for (int[] point : points) {
            set.add(point[0]);
        }
        int[] arr = set.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(arr);

        int res = 1;//最后的一个矩形
        int window = arr[0] + w;//窗口右边界
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > window) {
                res++;
                window = arr[i] + w;
            }
        }
        return res;
    }
}
