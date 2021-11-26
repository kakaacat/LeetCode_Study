package com.kaka.topic10;

/**
 * @Author : kaka
 * @Date: 2021-11-26 11:11
 *
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 *
 * 提示：
 * 1 <= s.length <= 20
 * 1 <= p.length <= 30
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 保证每次出现字符 * 时，前面都匹配到有效的字符
 */
public class RegularExpressionMatching {
    //从右到左扫描
    //链接：https://leetcode-cn.com/problems/regular-expression-matching/solution/shou-hui-tu-jie-wo-tai-nan-liao-by-hyj8/
    public boolean isMatch(String s, String p) {
        char[] sChar = s.toCharArray();
        char[] pChar = p.toCharArray();

        int sLen = s.length();
        int pLen = p.length();

        // dp[i][j]:表示s的前i个字符，p的前j个字符是否能够匹配
        boolean dp[][] = new boolean[sLen + 1][pLen + 1];

        //初始化
        //1.s、p都为空，肯定匹配
        dp[0][0] = true;
        //2.p为空，都不匹配，boolean默认为false
        //3. s为空，p不为空，由于*可以匹配0个字符，所以有可能为true
        for (int j = 1; j <= pLen; j++) {
            if (pChar[j - 1] == '*'){
                dp[0][j] = dp[0][j - 2];
            }
        }

        //填表
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                // 文本子串和模式子串末位字符能匹配上
                if (sChar[i - 1] == pChar[j - 1] || pChar[j - 1] == '.'){
                    dp[i][j] = dp[i - 1][j -1];
                } else if (pChar[j - 1] == '*'){    // 模式子串末位是 *
                    // 模式串*的前一个字符能够跟文本串的末位匹配上
                    if (sChar[i - 1] == pChar[j - 2] || pChar[j - 2] == '.'){
                        dp[i][j] = dp[i][j - 2]      // *匹配 0 次的情况
                                || dp[i - 1][j];     // *匹配 1 次或多次的情况
                    } else {    // 模式串 * 的前一个字符不能够跟文本串的末位匹配
                        dp[i][j] = dp[i][j - 2];     // *只能匹配 0 次
                    }
                }
            }
        }

        for (int i = 0; i <= sLen; i++) {
            for (int j = 0; j <= pLen; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[sLen][pLen];
    }
}
