package com.kaka.LC101_200.LC121_130.topic122;

import java.util.HashMap;

/**
 * @Author : kaka
 * @Date: 2022-04-08 17:30
 *
 * @Description: 560. 和为 K 的子数组
 *
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 *
 * https://leetcode-cn.com/problems/subarray-sum-equals-k/
 */
public class SubarraySumEqualsK {
    /**
     * 枚举
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j >=0; j--) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }

    /**
     * 前缀和+Hash表优化
     */
    public int subarraySum2(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }

        return count;
    }
}
