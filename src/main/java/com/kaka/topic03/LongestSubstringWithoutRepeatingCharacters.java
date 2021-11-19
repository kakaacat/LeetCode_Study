package com.kaka.topic03;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author : kaka
 * @Date: 2021-11-19 09:48
 *
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LongestSubstringWithoutRepeatingCharacters {
    //滑动窗口

    public int lengthOfLongestSubstring1(String s) {
        //哈希集合，记录字符是否出现过
        Set<Character> hashSet = new HashSet<Character>();

        int rk = -1, ans = 0;
        for(int i = 0; i < s.length(); i++){
            if (i != 0){
                //左指针右移，移除一个字符
                hashSet.remove(s.charAt(i - 1));
            }
            while(rk + 1 < s.length() && !hashSet.contains(s.charAt(rk + 1))){
                //不断移动右指针
                hashSet.add(s.charAt(rk + 1));
                ++rk;
            }
            //第i到rk个字符是一个极长的无重复字符串
            ans = Math.max(ans,rk - i + 1);
        }

        return ans;
    }
}
