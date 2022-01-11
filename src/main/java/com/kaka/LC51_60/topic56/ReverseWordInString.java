package com.kaka.LC51_60.topic56;

import java.util.*;

/**
 * @Author : kaka
 * @Date: 2022-01-11 15:22
 *
 * @Description: 151. 翻转字符串里的单词
 *
 * 给你一个字符串 s ，逐个翻转字符串中的所有单词 。
 * 单词是由非空格字符组成的字符串。s中使用至少一个空格将字符串中的单词分隔开。
 * 请你返回一个翻转 s 中单词顺序并用单个空格相连的字符串。
 * 说明：
 * 输入字符串 s 可以在前面、后面或者单词间包含多余的空格。
 * 翻转后单词间应当仅用一个空格分隔。
 * 翻转后的字符串中不应包含额外的空格。
 *  
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
 */
public class ReverseWordInString {
    /**
     * API
     * 时间复杂度：O(n)，其中 n 为输入字符串的长度。
     * 空间复杂度：O(n)，用来存储字符串分割之后的结果。
     */
    public String reverseWords(String s){
        //除去开头结尾的空格符
        s = s.trim();
        //正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }
}
