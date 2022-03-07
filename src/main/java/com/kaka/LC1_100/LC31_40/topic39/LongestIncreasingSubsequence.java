package com.kaka.LC1_100.LC31_40.topic39;

/**
 * @Author : kaka
 * @Date: 2021-12-24 11:15
 *
 * @Description: 最长递增子序列
 *
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 */
public class LongestIncreasingSubsequence {
    /**
     * 1.动态规划
     *
     * 时间复杂度：O(n^2)，其中 n 为数组 nums 的长度。动态规划的状态数为 n，计算状态 dp[i] 时，
     * 需要 O(n) 的时间遍历 dp[0…i−1] 的所有状态，所以总时间复杂度为 O(n^2).
     * 空间复杂度：O(n)，需要额外使用长度为 n 的 dp 数组。
     */
    public int lengthOfLIS1(int[] nums){
        if (nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxAns = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxAns = Math.max(maxAns, dp[i]);
        }
        return maxAns;
    }
    /**
     * 2.贪心+二分查找
     *
     * 时间复杂度：O(nlogn)。数组 nums 的长度为 n，我们依次用数组中的元素去更新 d 数组，
     * 而更新 d 数组时需要进行 O(logn) 的二分搜索，所以总时间复杂度为 O(nlogn)。
     *
     * 空间复杂度：O(n)，需要额外使用长度为 n 的 d 数组。
     */
    public int lengthOfLIS(int[] nums){
        int len = 1;
        if (nums.length == 0){
            return 0;
        }
        int[] d = new int[nums.length + 1];
        d[len] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > d[len]){
                d[++len] = nums[i];
            } else {
                //二分查找插入位置
                int l = 1, r = len, pos = 0;
                while (l <= r){
                    int mid = (l + r) >> 1;
                    if (d[mid] < nums[i]){
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }

        return len;
    }
}
