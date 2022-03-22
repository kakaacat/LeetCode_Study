package com.kaka.LC101_200.LC101_110.topic105;

/**
 * @Author : kaka
 * @Date: 2022-03-22 09:35
 *
 * @Description: 152. 乘积最大子数组
 *
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），
 * 并返回该子数组所对应的乘积。
 * 测试用例的答案是一个 32-位 整数。
 * 子数组 是数组的连续子序列。
 *
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
 */
public class MaxProduct {
    /**
     * 考虑当前位置如果是一个负数的话，
     * 那么我们希望以它前一个位置结尾的某个段的积也是个负数，这样就可以负负得正，
     * 并且我们希望这个积尽可能「负得更多」，即尽可能小。如果当前位置是一个正数的话，
     * 我们更希望以它前一个位置结尾的某个段的积也是个正数，并且希望它尽可能地大。
     */
    public int maxProduct(int[] nums) {
        int maxF = nums[0], minF = nums[0], ans = nums[0];
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            int mx = maxF, mi = minF;
            maxF = Math.max(mx * nums[i], Math.min(nums[i], mi * nums[i]));
            minF = Math.min(mi * nums[i], Math.min(nums[i], mx * nums[i]));
            ans = Math.max(maxF, minF);
        }

        return ans;
    }
}
