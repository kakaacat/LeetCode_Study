package com.kaka.DP.dp03;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author : kaka
 * @Date: 2022-04-30 09:56
 *
 * @Description: 22. 括号生成
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
public class GenerateParenthes {
    public List<String> generateParenthes(int n) {
        List<LinkedList<String>> result = new LinkedList<LinkedList<String>>();
        if (n == 0) {
            return result.get(0);
        }
        LinkedList<String> list0 = new LinkedList<>();
        list0.add("");
        result.add(list0);
        LinkedList<String> list1 = new LinkedList<>();
        list1.add("()");
        result.add(list1);

        for (int i = 2; i <= n; i++) {
            LinkedList<String> temp = new LinkedList<>();
            for (int j = 0; j < i; j++) {
                List<String> str1 = result.get(j);
                List<String> str2 = result.get(i - 1 - j);
                for (String s1 : str1) {
                    for (String s2 : str2) {
                        String el = "(" + s1 + ")" + s2;
                        temp.add(el);
                    }
                }
            }
            result.add(temp);
        }
        return result.get(n);
    }
}
