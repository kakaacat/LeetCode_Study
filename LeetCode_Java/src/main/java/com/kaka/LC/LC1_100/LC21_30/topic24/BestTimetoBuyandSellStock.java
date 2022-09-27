package com.kaka.LC.LC1_100.LC21_30.topic24;

/**
 * @Author : kaka
 * @Date: 2021-12-10 15:35
 *
 * @Description: 买卖股票的最佳时机
 *
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 */
public class BestTimetoBuyandSellStock {
    /**
     * 1.动态规划 + 空间优化
     *
     * 考虑每次如何获取最大收益？第i天的最大收益只需要知道前i天的最低点就可以算出来了。
     * 而第i天以前（包括第i天）的最低点和i-1天的最低点有关，至此我们的动态方程就出来了。
     * dp[i] = min(d[i-1],prices[i])
     * 其中dp[0]=prices[0],然后动态计算之后的就可以了。
     * 得到了前i天的最低点以后，只需要维护一个max用来保存最大收益就可以了。
     * 这个时候是空间复杂度O（n）的动态规划，代码如下：
     *         //dp[i]表示截止到i，价格的最低点是多少   dp[i]=min(dp[i-1],nums[i])
     *         int max = 0;
     *         int[] dp = new int[prices.length];
     *         dp[0] = prices[0];
     *         for (int i = 1; i < prices.length; i++) {
     *             dp[i] = (dp[i - 1] < prices[i]) ? dp[i - 1] : prices[i];
     *             max = (prices[i] - dp[i]) > max ? prices[i] - dp[i] : max;
     *         }
     *         return max;
     * 接着考虑优化空间，仔细观察动态规划的辅助数组，其每一次只用到了dp[-1]这一个空间，
     * 因此可以把数组改成单个变量dp来存储截止到第i天的价格最低点。
     */
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length ; i++) {
            minPrice = minPrice < prices[i] ? minPrice : prices[i];
            int profit = prices[i] - minPrice;
            maxProfit = maxProfit > profit ? maxProfit : profit;
        }
        return maxProfit;
    }
}
