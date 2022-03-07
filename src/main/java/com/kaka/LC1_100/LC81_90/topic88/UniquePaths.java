package com.kaka.LC1_100.LC81_90.topic88;

/**
 * @Author : kaka
 * @Date: 2022-03-04 09:15
 *
 * @Description: 62. 不同路径
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 *
 * 链接：https://leetcode-cn.com/problems/unique-paths
 */
public class UniquePaths {
    /**
     * 动态规划
     *
     * 时间复杂度：O(mn)
     * 空间复杂度：O(mn)
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 组合数学
     *
     */
    public int uniquePaths2(int m, int n) {
        long ans = 1;
        for (int i = n, j = 1; j < m; i++, j++) {
            ans = ans * i / j;
        }
        return (int) ans;
    }
}
