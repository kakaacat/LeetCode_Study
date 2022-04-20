package com.kaka.LC.LC1_100.LC21_30.topic25;

import java.util.Arrays;

/**
 * @Author : kaka
 * @Date: 2021-12-10 19:44
 *
 * @Description: 合并两个有序数组
 *
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 *
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 *
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。
 * 为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 *
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 */


public class MergeSortedArray {
    /**
     * 1.直接合并后排序
     *
     * 时间复杂度：O((m+n)log(m+n))。
     * 排序序列长度为 m+n，套用快速排序的时间复杂度即可，平均情况为 O((m+n)log(m+n))。
     *
     * 空间复杂度：O(log(m+n))。
     * 排序序列长度为 m+n，套用快速排序的空间复杂度即可，平均情况为 O(log(m+n))。
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n){
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    /**
     * 2.双指针
     *
     * 时间复杂度：O(m+n)。
     * 指针移动单调递增，最多移动 m+n 次，因此时间复杂度为 O(m+n)。
     *
     * 空间复杂度：O(m+n)。
     * 需要建立长度为 m+n 的中间数组 sorted
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n){
        int p1 =0, p2 =0;
        int[] sorted = new int[m + n];
        int cur;
        while(p1 < m || p2 < n){
            if(p1 == m){
                cur = nums2[p2++];
            }else if(p2 == n){
                cur = nums1[p1++];
            }else if(nums1[p1] < nums2[p2]){
                cur = nums1[p1++];
            }else{
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
        }
        for (int i = 0; i < (m + n); i++) {
            nums1[i] = sorted[i];
        }
    }

    /**
     * 3.逆向双指针
     *
     * 时间复杂度：O(m+n)。
     * 指针移动单调递减，最多移动 m+n 次，因此时间复杂度为 O(m+n)。
     *
     * 空间复杂度：O(1)。
     * 直接对数组 nums1 原地修改，不需要额外空间。
     */
    public void merge3(int[] nums1, int m, int[] nums2, int n){
        int p1 = m - 1;
        int p2 = n - 1;
        int tail = m + n - 1;
        int cur;
        while(p1 >= 0 || p2 >= 0){
            if (p1 == -1){
                cur = nums2[p2--];
            }else if(p2 == -1){
                cur = nums1[p1--];
            }else if(nums1[p1] > nums2[p2]){
                cur = nums1[p1--];
            }else{
                cur = nums2[p2--];
            }
            nums1[tail--] = cur;
        }
    }
}
