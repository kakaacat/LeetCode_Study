package com.kaka.LC1_100.LC31_40.topic38;

import static java.util.Arrays.binarySearch;

/**
 * @Author : kaka
 * @Date: 2021-12-24 10:21
 *
 * @Description: 二分查找
 *
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * 链接：https://leetcode-cn.com/problems/binary-search
 */
public class BinarySearch {
    public int search(int[] nums, int target){
        int l = 0;
        int r = nums.length - 1;
        while (l <= r){
            int mid = (l + r) / 2;
            if (nums[mid] == target){
                return mid;
            } else if (nums[mid] < target){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    /**
     *  调API
     */
    public int search2(int[] nums, int target){
        return binarySearch(nums, target);
    }
}
