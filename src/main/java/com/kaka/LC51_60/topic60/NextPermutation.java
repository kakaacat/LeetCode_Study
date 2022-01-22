package com.kaka.LC51_60.topic60;

/**
 * @Author : kaka
 * @Date: 2022-01-18 21:05
 *
 * @Description: 31. 下一个排列
 *
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须 原地 修改，只允许使用额外常数空间。
 *
 * 链接：https://leetcode-cn.com/problems/next-permutation
 */
public class NextPermutation {
    public void nextPermutation(int[] nums){
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i+1]){
            i--;
        }
        if (i >= 0){
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]){
                j--;
            }

            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int i) {
        int start = i, end = nums.length - 1;
        while (start < end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp;
        temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
