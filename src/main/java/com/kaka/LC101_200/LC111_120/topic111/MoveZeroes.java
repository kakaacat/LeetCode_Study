package com.kaka.LC101_200.LC111_120.topic111;

/**
 * @Author : kaka
 * @Date: 2022-03-28 09:42
 *
 * @Description: 283. 移动零
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 * https://leetcode-cn.com/problems/move-zeroes/
 */
public class MoveZeroes {
    /**
     * 交换，但不保证非零元素的相对顺序
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int r = 0, l = nums.length - 1;
        while (r < l) {
            if (nums[r] == 0) {
                while (nums[l] == 0) {
                    l--;
                }
                swap(nums, r, l);
                l--;
            }
            r++;
        }
    }

    private void swap(int[] nums, int r, int l) {
        int temp = nums[r];
        nums[r] = nums[l];
        nums[l] = temp;
    }

    /**
     * 不交换
     * @param nums
     */
    public void moveZeroes2(int[] nums) {
        int index = 0;
        //不是0的往前放
        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }
        //后面补0
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * 双指针交换
     */
    public void moveZeroes3(int[] nums) {
        int n = nums.length, r = 0, l = 0;
        while (r < n) {
            if (nums[r] != 0) {
                swap(nums, r ,l);
                l++;
            }
            r++;
        }
    }
}
