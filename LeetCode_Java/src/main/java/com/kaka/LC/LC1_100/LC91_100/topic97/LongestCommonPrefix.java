package com.kaka.LC.LC1_100.LC91_100.topic97;


/**
 * @Author : kaka
 * @Date: 2022-03-13 19:09
 *
 * @Description: 14. 最长公共前缀
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * https://leetcode-cn.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix {
    /**
     * 横向扫描
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        for (int i = 0; i < strs.length; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    private String longestCommonPrefix(String str1, String str2) {
        int len = Math.min(str1.length(), str2.length());
//        String prefix = "";
//        for (int i = 0; i < len; i++) {
//            if (str1.charAt(i) == str2.charAt(i)) {
//                prefix += str1.charAt(i);
//            } else  {
//                break;
//            }
//        }
//        return prefix;
        int index = 0;
        while (index < len && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }

    /**
     * 纵向
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int len = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < len; i++) {
            char c = strs[0].charAt(i);
            for (int j = 0; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
