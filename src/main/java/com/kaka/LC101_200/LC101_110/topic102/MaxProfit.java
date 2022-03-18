package com.kaka.LC101_200.LC101_110.topic102;

/**
 * @Author : kaka
 * @Date: 2022-03-18 10:06
 *
 * @Description: 122. 买卖股票的最佳时机 II
 *
 * 给定一个数组 prices ，其中 prices[i] 表示股票第 i 天的价格。
 * 在每一天，你可能会决定购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。
 * 你也可以购买它，然后在 同一天 出售。
 * 返回 你能获得的 最大 利润 。
 *
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 */
public class MaxProfit {
    /**
     * 贪心
     */
    public int maxProfit(int[] prices) {
       int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }

    /**
     * 动态规划
     */
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        if (n < 2) {
            return 0;
        }

        // cash：持有现金
        // hold：持有股票
        // 状态转移：cash → hold → cash → hold → cash → hold → cash
        int cash = 0;
        int hold = -prices[0];

        // 0：持有现金
        // 1：持有股票
        // 状态转移：0 → 1 → 0 → 1 → 0 → 1 → 0
        //int[][] dp = new int[len][2];
        //dp[0][0] = 0;
        //dp[0][1] = -prices[0];

        int proCash = cash;
        int proHold = hold;
        for (int i = 1; i < n; i++) {
            //dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            //dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);

            cash = Math.max(proCash, proHold + prices[i]);
            hold = Math.max(proHold, proCash - prices[i]);

            proCash = cash;
            proHold = hold;
        }
        //return dp[len - 1][0];
        return cash;
    }
}