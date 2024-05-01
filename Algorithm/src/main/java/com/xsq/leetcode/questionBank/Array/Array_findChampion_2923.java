package src.com.xsq.leetcode.questionBank.Array;

/**
 * 2923.找到冠军 I
 * 一场比赛中共有 n 支队伍，按从 0 到  n - 1 编号
 * 给你一个下标从 0 开始、大小为 n * n 的二维布尔矩阵 grid 。对于满足 0 <= i, j <= n - 1 且 i != j 的所有 i, j ：如果 grid[i][j] == 1，那么 i 队比 j 队强 ；否则，j 队比 i 队强
 * 在这场比赛中，如果不存在某支强于 a 队的队伍，则认为 a 队将会是冠军。返回这场比赛中将会成为冠军的队伍
 */
public class Array_findChampion_2923 {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{0,1},{0,0}};
        System.out.println(findChampion(grid));//0
        int[][] grid2 = new int[][]{{0,0,1},{1,0,1},{0,0,0}};
        System.out.println(findChampion(grid2));//1
        int[][] grid3 = new int[][]{{0,0,0},{1,0,0},{1,1,0}};
        System.out.println(findChampion(grid3));
    }

    /**
     * 若第i行除去i=j，其他数均为1，则i为冠军
     */
    public static int findChampion(int[][] grid) {
        int n = grid.length;
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (i != j && grid[i][j] == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag == true) {
                return i;
            }
            flag = true;//复位
        }
        return -1;
    }

    /**
     * 找到第一个满足 sum(grid[i])=n−1的i即可
     */
    public static int findChampion2(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            int[] row = grid[i];
            int sum = 0;
            for (int num : row) {
                sum += num;
            }
            if (sum == n-1) {
                return i;
            }
        }
        return -1;
    }
}
