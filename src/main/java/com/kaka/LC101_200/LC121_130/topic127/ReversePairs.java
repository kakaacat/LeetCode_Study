package com.kaka.LC101_200.LC121_130.topic127;

/**
 * @Author : kaka
 * @Date: 2022-04-14 20:37
 *
 * @Description: 剑指 Offer 51. 数组中的逆序对
 *
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 *
 * https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 */
public class ReversePairs {
    /**
     * 归并
     */
    public int reversePairs(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return 0;
        }

        //不改变原数组
        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = nums[i];
        }

        int[] temp = new int[len];
        return reversePairs(copy, 0, len - 1, temp);
    }

    private int reversePairs(int[] nums, int left, int right, int[] temp) {
        if (left == right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        int leftPairs = reversePairs(nums, left, mid, temp);
        int rightPairs = reversePairs(nums, mid + 1, right, temp);

        if (nums[mid] <= nums[mid + 1]) {
            return leftPairs + rightPairs;
        }

        int crossPairs = mergerAndCount(nums, left, mid, right, temp);
        return leftPairs + rightPairs + crossPairs;
    }

    private int mergerAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        //计数器
        int count = 0;

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[t++] = nums[i++];
            } else {
                temp[t++] = nums[j++];
                count += (mid - i) + 1;
            }
        }

        while (i <= mid) {
            temp[t++] = nums[i++];
        }
        while (j <= right) {
            temp[t++] = nums[j++];
        }

        //将temp中的元素  全部都copy到原数组里边去
        t = 0;
        while (left <= right) {
            nums[left++] = temp[t++];
        }

        return count;
    }
}
