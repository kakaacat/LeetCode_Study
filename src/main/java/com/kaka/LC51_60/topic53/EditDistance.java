package com.kaka.LC51_60.topic53;

/**
 * @Author : kaka
 * @Date: 2022-01-08 18:00
 *
 * @Description: 72. 编辑距离
 *
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *  
 * 链接：https://leetcode-cn.com/problems/edit-distance
 */
public class EditDistance {
    /**
     * 动态规划
     *
     * 时间复杂度 ：O(mn)，其中 m 为 word1 的长度，n 为 word2 的长度。
     * 空间复杂度 ：O(mn)，我们需要大小为 O(mn) 的 dp 数组来记录状态值。
     */
    public int minDistance(String word1, String word2){
        int n = word1.length();
        int m = word2.length();

        if (n * m == 0){
            return n + m;
        }

        //dp数组
        int[][] dp = new int[n + 1][m + 1];

        //边界初始化
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int left = dp[i][j - 1] + 1;
                int up = dp[i - 1][j] + 1;
                int leftUp = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)){
                    leftUp += 1;
                }
                dp[i][j] = Math.min(left, Math.min(up, leftUp));
            }
        }

        return dp[n][m];
    }
}
