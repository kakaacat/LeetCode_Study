package com.kaka.LC101_200.LC101_110.topic104;

/**
 * @Author : kaka
 * @Date: 2022-03-21 10:02
 *
 * @Description: 198. 打家劫舍
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * 链接：https://leetcode-cn.com/problems/house-robber
 */
public class HouseRobber {
    /**
     * 动态规划
     */
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0 || nums == null) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }
}
