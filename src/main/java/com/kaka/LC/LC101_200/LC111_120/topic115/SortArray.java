package com.kaka.LC.LC101_200.LC111_120.topic115;

/**
 * @Author : kaka
 * @Date: 2022-04-01 10:05
 *
 * @Description: 912. 排序数组
 *
 * 给你一个整数数组 nums，请你将该数组升序排列。
 *
 * https://leetcode-cn.com/problems/sort-an-array/
 */
public class SortArray {
    /**
     * 归并排序--分治法
     */
    int[] temp;
    public int[] sortArray(int[] nums) {
        temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        //分
        int mid = (l + r) / 2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        //治
        int i = l, j = mid + 1;
        int cur = 0;
        // 把较小的数先移到新数组中
        while (i <= mid && j <= r) {
            if (nums[i] < nums[j]) {
                temp[cur++] = nums[i++];
            } else {
                temp[cur++] = nums[j++];
            }
        }
        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[cur++] = nums[i++];
        }
        // 把右边边剩余的数移入数组
        while (j <= r) {
            temp[cur++] = nums[j++];
        }

        // 把新数组中的数覆盖nums数组
        for (int k = 0; k < r - l + 1; k++) {
            nums[k + l] = temp[k];
        }
    }
}
