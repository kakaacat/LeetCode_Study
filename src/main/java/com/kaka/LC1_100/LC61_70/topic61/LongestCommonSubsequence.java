package com.kaka.LC1_100.LC61_70.topic61;

/**
 * @Author : kaka
 * @Date: 2022-01-22 11:21
 *
 * @Description: 1143. 最长公共子序列
 *
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 * 一个字符串的 子序列 是指这样一个新的字符串：
 * 它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 *
 * 链接：https://leetcode-cn.com/problems/longest-common-subsequence
 */
public class LongestCommonSubsequence {
    /**
     * 动态规划
     *
     * 时间复杂度：O(mn)，其中 m 和 n 分别是字符串 text1和 text2的长度。二
     * 维数组 dp 有 m+1 行和 n+1 列，需要对 dp 中的每个元素进行计算。
     * 空间复杂度：O(mn)，其中 m 和 n 分别是字符串 text1和 text2的长度。
     * 创建了 m+1 行 n+1 列的二维数组 dp。
     */
    public int longestCommonSubsequence(String text1, String text2){
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
