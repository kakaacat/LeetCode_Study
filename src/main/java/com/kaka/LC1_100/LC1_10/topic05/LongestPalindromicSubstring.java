package com.kaka.LC1_100.LC1_10.topic05;


import java.util.ArrayList;
import java.util.List;

/**
 * @Author : kaka
 * @Date: 2021-11-21 15:58
 *
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 * 1 <= s.length <= 1000
 */
public class LongestPalindromicSubstring {
    /**
     * 1.暴力解法
     * 暴力求解，列举所有的子串，判断是否为回文串，保存最长的回文串。
     * 时间复杂度：两层 for 循环 O(n²)，for 循环里边判断是否为回文 O(n)，所以时间复杂度为 O(n³)。
     *
     * 空间复杂度：O(1)，常数个变量。
     */
    private boolean isPalindromic(char[] cs, int i, int j){

        while(i < j){
            if(cs[i++] != cs[j--]){
                return false;
            }
        }
        return true;
    }
    public String longestPalindrome1(String s){
        int len = s.length();
        if (len < 2){
            return s;
        }
        //因为字符串截取也是消耗性能的，所以只有最后截取就行
        int maxLen = 1;
        int begin = 0;
        char[] cs = s.toCharArray();

        for (int i = 0; i < len - 1; i++) {     //最后一个没必要枚举
            for (int j = i + 1; j < len; j++) {
                int currentLen = j - i + 1;
                if (isPalindromic(cs,i,j) && currentLen > maxLen){
                    maxLen = currentLen;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    /**
     * 2.中心扩散
     * 我们枚举所有的「回文中心」并尝试「扩展」，直到无法扩展为止，此时的回文串长度即为此「回文中心」下的最长回文串长度。
     * 时间复杂度：O(n^2),其中 n 是字符串的长度。
     * 长度为 1 和 2 的回文中心分别有 n和 n-1 个，每个回文中心最多会向外扩展 O(n)次。
     *
     * 空间复杂度：O(1)。
     */
    private int expandCenter(String s,int left,int right){
        // left = right 的时候，此时回文中心是一个字符，回文串的长度是奇数
        // right = left + 1 的时候，此时回文中心是一个空隙，回文串的长度是偶数

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            //向两边扩展
            --left;
            ++right;
        }
        return right - left - 1;    //返回回文子串的长度
    }
    public String longestPalindrome2(String s){
        int len = s.length();
        if (s == null || len < 1){
            return s;
        }

        //char[] cs = s.toCharArray();
        int maxLen = 1;
        int begin = 0;

        for (int i = 0; i < len; i++) {
            int oddLen = expandCenter(s, i, i);     //奇数的回文串
            int evenLen = expandCenter(s,i,i + 1);  //偶数的回文串

            int curMaxLen = Math.max(oddLen, evenLen);
            if (maxLen < curMaxLen){
                maxLen = curMaxLen;
                //画图找规律
                begin = i - (maxLen - 1) / 2;
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    /**
     * 3.动态规划
     * 回文天然具有「状态转移」性质：一个长度严格大于 2 的回文去掉头尾字符以后，剩下的部分依然是回文。
     * 反之，如果一个字符串头尾两个字符都不相等，那么这个字符串一定不是回文。
     *「动态规划」的方法根据这样的性质得到。
     *
     * 时间复杂度：O(n^2)其中 n 是字符串的长度。
     * 动态规划的状态总数为 O(n^2)，对于每个状态，我们需要转移的时间为 O(1)。
     *
     * 空间复杂度：O(n^2)，即存储动态规划状态需要的空间。
     */
    public String longestPalindrome3(String s){
        int len = s.length();
        if (len < 2){
            return s;
        }

        //dp[i][j]:表示s[i][j]是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：单独一个字符肯定是回文子串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        int maxLen = 1;
        int begin = 0;
        char[] cs = s.toCharArray();

        // 上三角区域，按列从上到下填
        for (int j = 0; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (cs[i] != cs[j]){    // 首尾不相等时，必不是回文串
                    dp[i][j] = false;
                }else{
                    // 首尾相等时，有2种情况
                    // 情况1：s[i...j]长度不超过3，不用检查必为回文串
                    // 情况2：s[i...j]长度大于3，由s[i+1...j-1]来判断

                    // dp[i][j] = j - i + 1 <= 3 || dp[i + 1][j - 1];
                    if (j - i < 3){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                // 更新max和begin
                if (dp[i][j] && j - i + 1 > maxLen){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }


    /**
     * 4.Manacher算法
     * 马拉车算法 Manacher‘s Algorithm 是用来查找一个字符串的最长回文子串的线性方法
     * 由一个叫 Manacher 的人在 1975 年发明的
     * 这个方法的最大贡献是在于将时间复杂度提升到了线性。
     *
     * 时间复杂度：O(n)，其中 n 是字符串的长度。
     * 空间复杂度：O(n)，我们需要 O(n)的空间记录每个位置的臂长。
     */

    public String preProcess(String s) {
        int n = s.length();
        if (n == 0) {
            return "^$";
        }
        String ret = "^";
        for (int i = 0; i < n; i++) {
            ret += "#" + s.charAt(i);
        }
        ret += "#$";
        return ret;
    }
    // 马拉车算法
    public String longestPalindrome4(String s) {
        String T = preProcess(s);
        int n = T.length();
        int[] P = new int[n];
        int C = 0, R = 0;
        for (int i = 1; i < n - 1; i++) {
            int i_mirror = 2 * C - i;
            if (R > i) {
                P[i] = Math.min(R - i, P[i_mirror]);// 防止超出 R
            } else {
                P[i] = 0;// 等于 R 的情况
            }

            // 碰到之前讲的三种情况时候，需要利用中心扩展法
            while (T.charAt(i + 1 + P[i]) == T.charAt(i - 1 - P[i])) {
                P[i]++;
            }

            // 判断是否需要更新 R
            if (i + P[i] > R) {
                C = i;
                R = i + P[i];
            }

        }
        // 找出 P 的最大值
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            if (P[i] > maxLen) {
                maxLen = P[i];
                centerIndex = i;
            }
        }
        int start = (centerIndex - maxLen) / 2; //最开始讲的求原字符串下标
        return s.substring(start, start + maxLen);
    }
}
