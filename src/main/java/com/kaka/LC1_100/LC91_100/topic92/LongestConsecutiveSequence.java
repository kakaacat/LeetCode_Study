package com.kaka.LC1_100.LC91_100.topic92;

import java.util.HashSet;

/**
 * @Author : kaka
 * @Date: 2022-03-08 09:24
 *
 * @Description: 128. 最长连续序列
 *
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
 */
public class LongestConsecutiveSequence {
    /**
     * hashset
     */
    public int longestConsecutiveSequence(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestSequence = 0;
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currNum = num;
                int currSequence = 1;

                while (numSet.contains(currNum + 1)) {
                    currNum += 1;
                    currSequence += 1;
                }
                longestSequence = Math.max(longestSequence, currSequence);
            }
        }
        return longestSequence;
    }
}
