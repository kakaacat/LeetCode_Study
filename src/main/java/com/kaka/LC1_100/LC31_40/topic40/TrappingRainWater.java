package com.kaka.LC1_100.LC31_40.topic40;

/**
 * @Author : kaka
 * @Date: 2021-12-26 16:37
 *
 * @Description: 接雨水
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，
 * 可以接 6 个单位的雨水（蓝色部分表示雨水）。
 *
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 */
public class TrappingRainWater {
    /**
     * 1.暴力
     *
     * 时间复杂度： O(n^2)。数组中的每个元素都需要向左向右扫描。
     * 空间复杂度 O(1) 的额外空间。
     */
    public int trap(int[] height){
        int ans = 0;
        int size = height.length;
        for (int i = 1; i < size; i++) {
            int maxLeft = 0, maxRight = 0;
            //找左边最大
            for (int j = i; j >= 0; j--) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            //找右边最大
            for (int j = i; j < size; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }
            //选出两边最大值的较小值
            ans += Math.min(maxLeft, maxRight) - height[i];
        }
        return ans;
    }

    /**
     * 2.动态编程
     * 在暴力方法中，我们仅仅为了找到最大值每次都要向左和向右扫描一次。
     * 但是我们可以提前存储这个值。因此，可以通过动态编程解决。
     *
     * 时间复杂度：O(n)。
     * 存储最大高度数组，需要两次遍历，每次 O(n) 。
     * 最终使用存储的数据更新ans ，O(n)。
     * 空间复杂度：O(n) 额外空间。
     * 和方法 1 相比使用了额外的 O(n) 空间用来放置 left_max 和 right_max 数组。
     */

    public int trap2(int[] height){
        if (height == null || height.length == 0){
            return 0;
        }
        int ans = 0;
        int size = height.length;

        int[] maxLeft = new int[size];
        int[] maxRight = new int[size];

        //存储左边最大值
        maxLeft[0] = height[0];
        for (int i = 1; i < size; i++) {
            maxLeft[i] = Math.max(maxLeft[i- 1], height[i]);
        }
        //存储右边最大值
        maxRight[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i]);
        }

        for (int i = 1; i < size - 1; i++) {
            ans += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }

        return ans;
    }
}
