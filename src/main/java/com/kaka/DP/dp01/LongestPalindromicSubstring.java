package com.kaka.DP.dp01;

/**
 * @Author : kaka
 * @Date: 2022-04-20 19:54
 *
 * @Description: 5. 最长回文子串
 *
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class LongestPalindromicSubstring {
    /**
     * 动态规划
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        //定义dp数组并初始化
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        //标量
        int maxLen = 1;
        int begin = 0;

        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                int curLen = j - i + 1;
                if (dp[i][j] && curLen > maxLen) {
                    maxLen = curLen;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }
}
