package com.kaka.LC.LC101_200.LC111_120.topic112;

/**
 * @Author : kaka
 * @Date: 2022-03-29 09:53
 *
 * @Description: 209. 长度最小的子数组
 *
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。
 * 如果不存在符合条件的子数组，返回 0 。
 *
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 */
public class MinSizeSubarray {
    /**
     * 滑动窗口
     */
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int start = 0, end = 0, sum = 0;
        int ans = Integer.MAX_VALUE;
        while (end < len) {
            sum += nums[end];
            while (sum >= target) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
