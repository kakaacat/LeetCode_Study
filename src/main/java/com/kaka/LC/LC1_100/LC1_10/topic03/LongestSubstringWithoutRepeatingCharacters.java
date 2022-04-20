package com.kaka.LC.LC1_100.LC1_10.topic03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author : kaka
 * @Date: 2021-11-19 09:48
 *
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {
    /**滑动窗口
     * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/wu-zhong-fu-zi-fu-de-zui-chang-zi-chuan-by-leetc-2/
     * */

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

    /**
     * 定义一个 map 数据结构存储 (k, v)，其中 key 值为字符，value 值为字符位置 +1，加 1 表示从字符位置后一个才开始不重复
     * 我们定义不重复子串的开始位置为 start，结束位置为 end
     * 随着 end 不断遍历向后，会遇到与 [start, end] 区间内字符相同的情况，
     * 此时将字符作为 key 值，获取其 value值(即索引值)，并更新 start，此时 [start, end] 区间内不存在重复字符
     * 无论是否更新 start，都会更新其 map 数据结构和结果 ans。
     * 时间复杂度：O(n)
     * */
    public int lengthOfLongestSubstring2(String s){
        Map<Character, Integer> hashMap = new HashMap<Character, Integer>();
        int ans = 0;
        for (int end = 0, start = 0; end < s.length(); ++end){
            char alpha = s.charAt(end);
            if (hashMap.containsKey(alpha)){
                //更新start，并可以保证start只会往前移动（例如abba）
                start = Math.max(start, hashMap.get(alpha));
            }
            hashMap.put(alpha, end + 1);
            ans = Math.max(ans,end - start + 1);
        }
        return ans;
    }

}
