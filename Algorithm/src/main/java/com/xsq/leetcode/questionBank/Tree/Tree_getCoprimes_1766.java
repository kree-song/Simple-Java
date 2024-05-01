package src.com.xsq.leetcode.questionBank.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1766.互质树
 * 给你一个n个节点的树（也就是一个无环连通无向图），节点编号从0到n - 1，且恰好有n - 1条边，每个节点有一个值。树的根节点为0号点。
 * 给你一个整数数组nums和一个二维数组edges来表示这棵树。nums[i]表示第i个点的值，edges[j] = [uj, vj] 表示节点 uj 和节点 vj 在树中有一条边
 * 当 gcd(x, y) == 1 ，我们称两个数x和y是互质的，其中gcd(x, y)是x和y的最大公约数
 * 从节点i到根最短路径上的点都是节点i的祖先节点。一个节点不是它自己的祖先节点
 * 请你返回一个大小为n的数组ans，其中ans[i]是离节点i最近的祖先节点且满足nums[i]和nums[ans[i]]是互质的 ，如果不存在这样的祖先节点，ans[i]为-1
 */
public class Tree_getCoprimes_1766 {
    List<Integer>[] gcds;
    List<Integer>[] tmp; // tmp[i]表示在搜索过程中i=nums[x]的节点坐标集合，显然该集合的末尾元素离当前节点最近;对于每个整数y，tmp[y]中存储的最后一个位置，就是与当前节点距离最近的祖先节点的位置
    List<Integer>[] g;
    int[] dep;
    int[] ans;

    public int[] getCoprimes(int[] nums, int[][] edges) {
        int n = nums.length;
        // 初始化
        gcds = new List[51];
        tmp = new List[51];
        for (int i = 0; i <= 50; i++) {
            gcds[i] = new ArrayList<>();
            tmp[i] = new ArrayList<>();
        }
        ans = new int[n];
        dep = new int[n];
        Arrays.fill(ans, -1);
        Arrays.fill(dep, -1);
        g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }

        //预处理gcds[j]表示[1,50]中与j互质的元素的集合
        for (int i = 1; i <= 50; i++) {
            for (int j = 1; j <= 50; j++) {
                if (gcd(i, j) == 1) {
                    gcds[i].add(j);
                }
            }
        }

        //g[i]表示序号为i的点与哪些节点序号相连
        for (int[] val : edges) {
            g[val[0]].add(val[1]);
            g[val[1]].add(val[0]);
        }

        dfs(nums, 0, 1);

        return ans;
    }

    /**
     * 求最大公约数
     */
    public int gcd(int x, int y) {
        while (y != 0) {
            int temp = x;
            x = y;
            y = temp % y;
        }
        return x;
    }

    public void dfs(int[] nums, int x, int depth) {
        dep[x] = depth;
        for (int val : gcds[nums[x]]) {
            if (tmp[val].isEmpty()) {
                continue;
            }

            int las = tmp[val].get(tmp[val].size() - 1);
            if (ans[x] == -1 || dep[las] > dep[ans[x]]) {
                ans[x] = las;
            }
        }
        tmp[nums[x]].add(x);

        for (int val : g[x]) {
            if (dep[val] == -1) { // 被访问过的点dep不为-1
                dfs(nums, val, depth + 1);
            }
        }

        tmp[nums[x]].remove(tmp[nums[x]].size() - 1);
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2,3,3,2};
        int[][] edges = new int[][]{{0,1},{1,2},{1,3}};
        int[] nums2 = new int[]{5,6,10,2,3,6,15};
        int[][] edges2 = new int[][]{{0,1},{0,2},{1,3},{1,4},{2,5},{2,6}};
        Tree_getCoprimes_1766 test = new Tree_getCoprimes_1766();
        int[] coprimes = test.getCoprimes(nums, edges);
    }
}
