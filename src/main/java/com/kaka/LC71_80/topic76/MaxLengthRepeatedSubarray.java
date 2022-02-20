package com.kaka.LC71_80.topic76;

/**
 * @Author : kaka
 * @Date: 2022-02-20 12:04
 *
 * @Description: 718. 最长重复子数组
 *
 * 给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
 *
 * https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/
 */
public class MaxLengthRepeatedSubarray {
    /**
     * 动态规划
     */
    public int findLength(int[] num1, int[] num2) {
        int n = num1.length, m = num2.length;
        int[][] dp = new int[n + 1][m + 1];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (num1[i - 1] == num2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = Math.max(dp[i][j], ans);
                }
            }
        }
        return ans;
    }
}
