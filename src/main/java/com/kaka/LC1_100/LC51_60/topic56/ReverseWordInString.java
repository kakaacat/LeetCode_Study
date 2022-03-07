package com.kaka.LC1_100.LC51_60.topic56;

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

    /**
     *
     */
    public String reverseWords2(String s) {
        // 存放结果
        StringBuilder res = new StringBuilder();
        // 定义两个指针，并指向尾部
        int left = s.length() - 1;
        int right = s.length() - 1;
        while (left >= 0) {
            // 排除尾部是空格的情况，并将两指针挪动到非空格字母上
            while (left >= 0 && s.charAt(left) == ' ') {
                left--;
            }
            right = left;
            if (right < 0) {
                break;
            }
            // 当left指针所指不为空格时，一直挪动到为空格为止
            while (left >= 0 && s.charAt(left) != ' ') {
                left--;
            }
            res.append(s.substring(left + 1, right + 1));
            res.append(" ");
        }
        return res.substring(0, res.length() - 1).toString();
    }
    /**
     * 双端队列（栈）
     */
    public String reverseWords3(String s) {
        int left = 0, right = s.length() - 1;
        // 去掉字符串开头的空白字符
        while (left <= right && s.charAt(left) == ' ') {
            ++left;
        }

        // 去掉字符串末尾的空白字符
        while (left <= right && s.charAt(right) == ' ') {
            --right;
        }

        Deque<String> stack = new ArrayDeque<String>();
        StringBuilder word = new StringBuilder();

        while (left <= right) {
            char c = s.charAt(left);
            if ((word.length() != 0) && (c == ' ')) {
                stack.push(word.toString());
                //stack.offerFirst(word.toString());
                word.setLength(0);
            } else if (c != ' ') {
                word.append(c);
            }
            ++left;
        }
        stack.push(word.toString());
        //stack.offerFirst(word.toString());

        return String.join(" ", stack);
    }
}
