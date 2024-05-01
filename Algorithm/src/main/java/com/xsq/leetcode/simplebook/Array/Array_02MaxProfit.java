package src.com.xsq.leetcode.simplebook.Array;

/*
 * 买卖股票的最佳时机 II
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）
 * */
public class Array_02MaxProfit {
    public static void main(String[] args) {
        int[] arr = new int[]{7, 1, 5, 3, 6, 4};
        Array_02MaxProfit mp = new Array_02MaxProfit();
        System.out.println(mp.maxProfit04(arr));
    }

    //动态规划解决
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;//第一天收盘后手里没有股票的利润
        dp[0][1] = -prices[0];//第一天收盘后手里有股票的利润
        for (int i = 1; i < prices.length; i++) {
            //dp[i-1][0]:昨天手里就没有股票了
            //dp[i-1][1]+prices[i]:昨天有股票但是今天卖了
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);//第i天收盘后 手里没有股票 的利润
            //dp[i-1][1]:昨天手里就有股票了
            //dp[i-1][]+prices[i]:昨天没有股票但是今天买了
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);//第i天收盘后 手里有股票 的利润
        }
        return dp[prices.length - 1][0];
    }

    //改进
    public int maxProfit02(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
        int hold = -prices[0];
        int noHold = 0;
        for (int i = 1; i < prices.length; i++) {
            noHold = Math.max(noHold, hold + prices[i]);
            hold = Math.max(hold, noHold - prices[i]);
        }
        return noHold;
    }

    //贪心算法 ---局部最优解
    public int maxProfit03(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
        int total = 0, index = 0;
        while (index < prices.length) {
            //若股票下跌就一直找，直到找到上涨为止
            while (index < prices.length - 1 && prices[index] >= prices[index + 1])
                index++;
            //记录股票开始上涨的值，即为区间最小值
            int min = prices[index];
            //一直找到股票上涨的最大值为止
            while (index < prices.length - 1 && prices[index] <= prices[index + 1])
                index++;
            //index++:使其指向下一个区间位置，不必再次判断为下跌
            total += prices[index++] - min;
        }
        return total;
    }

    public int maxProfit04(int[] prices) {
        int total = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            //原数组中后一个减去前一个为正数就说明是上涨的，就累加
            total += Math.max(prices[i + 1] - prices[i], 0);
        }
        return total;
    }


    public int maxProfit_self(int[] prices) {
        int left = 0;
        int count = 0;
        int bank = 0;
        int a = 0;
        while (left != prices.length + 1) {
            for (int right = 1; right < prices.length; right++) {
                if (prices[left] < prices[right] && prices[right] - prices[left] > count) {
                    count = prices[right] - prices[left];
                    a = right;
                }
            }
            bank += count;
            count = 0;
            if (a != 0) {
                left = a;
            }
            left++;
        }

        return bank;
    }
}
