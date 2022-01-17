package com.kaka.LC51_60.topic59;

import java.util.HashMap;

/**
 * @Author : kaka
 * @Date: 2022-01-17 16:24
 *
 * @Description: 76. 最小覆盖子串
 *
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
 * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 注意：
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *  
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 */
public class MinWindowsSubstring {
    HashMap<Character, Integer> need = new HashMap<Character, Integer>();
    HashMap<Character, Integer> window = new HashMap<Character, Integer>();

    public String minWindow(String s, String t){
        int tLen = t.length();
        int sLen = s.length();
        if (tLen == 0 || sLen == 0){
            return "";
        }

        //先把t中的字符放到need中
        for (int i = 0; i < tLen; i++){
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int len = Integer.MAX_VALUE, start = 0;
        int valid = 0;  //已经匹配成功的字符种类数（非字符个数）
        while (right < sLen){
            char c = s.charAt(right);
            right++;    //右指针向右滑

            //如果右指针现在滑到的字符是目标字符串的一个，那么更新窗口中的数据
            if (need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))){
                    valid++;
                }
            }

            //窗口开始从左边收缩
            while (valid == need.size()){
                if (right - left < len){
                    start = left;
                    len = right - left;
                }

                char d = s.charAt(left);
                left++;

                if (need.containsKey(d)){
                    if (window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
