package com.kaka.LC81_90.topic87;


/**
 * @Author : kaka
 * @Date: 2022-03-03 09:45
 *
 * @Description: 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 进阶：
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *  
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 */
public class SearchRange {
    /**
     * 二分查找 O(log n) 
     */
    public int[] searchRange(int[] nums, int target) {
        int leftIndex = binarySearch(nums, target - 1);
        int rightIndex = binarySearch(nums, target) - 1;
        if (leftIndex <= rightIndex && nums[leftIndex] == target) {
            return new int[]{leftIndex, rightIndex};
        }
        return  new int[]{-1, -1};
    }

    // 第一个大于 target 的数的下标
    private int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length -1, ans = nums.length;
        while (l <= r) {
            int mid = (r + l) >> 1;
            if (nums[mid] > target) {
                r = mid -1;
                ans = mid;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}
