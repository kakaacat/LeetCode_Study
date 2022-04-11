package com.kaka.LC101_200.LC121_130.topic124;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author : kaka
 * @Date: 2022-04-11 10:28
 *
 * @Description: 139. 单词拆分
 *
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 *
 * 链接：https://leetcode-cn.com/problems/word-break
 */
public class WordBreak {
    /**
     * 动态规划
     * @param s
     * @param wordDict
     * @return
     */
    public boolean workBreak(String s, List<String> wordDict) {
        int len = s.length();
        Set<String> set = new HashSet(wordDict);
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
    /**
     * 优化一下，dp[i]只需要往前探索到词典里最长的单词的长度即可
     */
    public boolean workBreak2(String s, List<String> wordDict) {
        int len = s.length(), maxword = 0;
        Set<String> set = new HashSet<>();
        for (String word : wordDict) {
            set.add(word);
            maxword = Math.max(maxword, word.length());
        }

        boolean[] dp = new boolean[len + 1];
        dp[0] = true;

        for (int i = 1; i <= len; i++) {
            for (int j = i; j >= 0 && j >= i - maxword; j--) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[len];
    }
}
