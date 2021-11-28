package com.kaka.LC11_20.topic11;

/**
 * @Author : kaka
 * @Date: 2021-11-27 19:18
 *
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 */
public class ContainerWithMostWater {
    /**
     * 双指针
     *
     * 时间复杂度：O(N)，双指针总计最多遍历整个数组一次。
     * 空间复杂度：O(1)，只需要额外的常数级别的空间。
     */
    public int maxArea(int[] height) {
        int l = 0;  //左指针
        int r = height.length - 1;  //右指针
        int area;   //面积
        int ans = 0;

        while (l < r){
            area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(area, ans);
            if(height[l] <= height[r]){
                l++;
            } else {
                r--;
            }
        }

        return ans;
    }
}
