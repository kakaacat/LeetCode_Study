package com.kaka.LC61_70.topic66;

/**
 * @Author : kaka
 * @Date: 2022-02-05 15:08
 *
 * @Description: 41. 缺失的第一个正数
 *
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 *
 * 链接：https://leetcode-cn.com/problems/first-missing-positive
 */
public class FilstMissingPositive {
    /**
     * 哈希表
     */
   public int filstMissingPositive(int[] nums){
        int n = nums.length;
       for (int i = 0; i < n; i++) {
           if (nums[i] <= 0){
               nums[i] = n + 1;
           }
       }

       for (int i = 0; i < n; i++) {
           int num = Math.abs(nums[i]);
           if (num <= n){
                nums[num - 1] = -Math.abs(nums[num - 1]);
           }
       }

       for (int i = 0; i < n; i++) {
           if (nums[i] > 0){
               return i + 1;
           }
       }

       return n + 1;
   }

    /**
     * 置换
     */
    public int firstMissingPositive2(int[] nums){

    }
}
