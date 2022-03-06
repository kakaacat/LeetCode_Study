package com.kaka.LC81_90.topic90;

/**
 * @Author : kaka
 * @Date: 2022-03-06 16:29
 *
 * @Description: 162. 寻找峰值
 *
 * 峰值元素是指其值严格大于左右相邻值的元素。
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 *
 * 链接：https://leetcode-cn.com/problems/find-peak-element
 */
public class FindPeekElement {
    /**
     * 寻找最大值
     *
     * 时间复杂度：O(n)，其中 n 是数组 nums 的长度。
     * 空间复杂度：O(1)。
     */
    public int findPeekelement(int[] nums) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[idx]) {
                idx = i;
            }
        }
        return idx;
    }
    /**
     * 二分查找之爬坡法
     *
     * 时间复杂度：O(logn)，其中 n 是数组 nums 的长度.
     * 空间复杂度：O(1)。
     */
    public int findPeekElement2(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] < nums[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }
}
