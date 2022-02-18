package com.kaka.LC71_80.topic74;

/**
 * @Author : kaka
 * @Date: 2022-02-18 13:05
 *
 * @Description: 32. 最长有效括号
 *
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 *
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 */
public class LongestValidParentheses {
    /**
     * 动态规划
     */
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2){
            return 0;
        }
        int[] dp = new int[s.length()];
        int max = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')'){
                int preLen = dp[i - 1];
                int pre = i - preLen - 1;

                if (pre >= 0 && s.charAt(pre) == '(') {
                    dp[i] = dp[i - 1] + 2;
                    // 【注意】此时，需要再往前看下，是否还有有效长度，如果有，合并过来
                    // 例如："()(()())" 当前在计算最后一个位置时，dp[7]已经等于 dp[6]+2 = 4+2
                    // 但需要再往前看一眼，dp[1]还有有效长度，合并过来 dp[7] = 4+2+2
                    // 那是否还需要再往前看？
                    // 不需要了，因为，如果前面还有有效长度，其长度肯定已经合并到dp[2]上了
                    // 因此，每次只需要再往前多看一眼就可以
                    if (pre - 1 >= 0) {
                        dp[i] += dp[pre - 1];
                    }
                }

                max = Math.max(max, dp[i]);
            }
        }

        return max;
    }
}
