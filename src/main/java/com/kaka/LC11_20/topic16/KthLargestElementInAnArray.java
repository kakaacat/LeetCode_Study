package com.kaka.LC11_20.topic16;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

/**
 * @Author : kaka
 * @Date: 2021-12-02 09:37
 *
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 *
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 */
public class KthLargestElementInAnArray {
    /**
     * 1、暴力排序
     * Arrays.sort
     *
     * 时间复杂度：O(NlogN)，这里 N 是数组的长度，算法的性能消耗主要在排序，JDK 默认使用快速排序，因此时间复杂度为 O(NlogN)；
     * 空间复杂度：O(logN)，这里认为编程语言使用的排序方法是「快速排序」，空间复杂度为递归调用栈的高度，为 logN。
     */
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums);
        return nums[len - k];
    }

    /**
     * 2.实现快排
     */

    private static Random random = new Random(System.currentTimeMillis());
    public int findKthLargest2(int[] nums, int k){
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int target = len - k;

        while(true){
            int index = quickSort(nums, left, right);
            if (index == target){
                return nums[index];
            }else if(index > target){
                right = index - 1;
            }else if (index < target){
                left = index + 1;
            }
        }

    }
    //快速排序,返回随机基准第K大的位置下标
    private int quickSort(int[] nums, int left, int right){
        //随机一个基准
        if (right > left) {
            int randomIndex = left + 1 + random.nextInt(right - left);
            swap(nums, left, randomIndex);
        }

        int pivot = nums[left];
        int j = left;   //用于记录left交换后位置
        for (int i = left + 1; i <= right ; i++) {
            if (nums[i] < pivot){
                swap(nums, ++j, i);
            }
        }
        if(nums[left] != nums[j]){
            swap(nums, left, j);
        }
        return j;

    }
    //交换
    private void swap(int[] nums, int l, int r){
        int temp = nums[r];
        nums[r] = nums[l];
        nums[l] = temp;
    }
}
