package com.kaka.LC1_100.LC1_10.topic04;

/**
 * @Author : kaka
 * @Date: 2021-11-20 11:06
 *
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 */
public class MedianOfTwoSortedArrays {
    /**
     * 简单粗暴，先将两个数组假合并。然后根据奇数，还是偶数，返回中位数。
     * 时间复杂度：O(m+n)。
     *
     * 空间复杂度：我们申请了常数个变量，也就是 m，n，len，left，right，aStart，bStart 以及 i。
     * 总共 8 个变量，所以空间复杂度是 O(1)。
     * */
    public double findMedianSortedArrays1(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int len = m + n;
        int left = -1, right = -1;
        int aStart = 0, bStart = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (aStart < m && (bStart >= n || A[aStart] < B[bStart])) {
                right = A[aStart++];
            } else {
                right = B[bStart++];
            }
        }
        if ((len & 1) == 0){
            return (left + right) / 2.0;
        } else {
            return right;
        }
    }

    /**
     * 用到二分查找的方法。
     * 我们不妨用另一种思路，题目是求中位数，其实就是求第 k 小数的一种特殊情况，而求第 k 小数有一种算法。
     * 时间复杂度：O(log(m+n))
     *
     * 空间复杂度：
     * 虽然我们用到了递归，但是可以看到这个递归属于尾递归，所以编译器不需要不停地堆栈
     * 所以空间复杂度为 O(1)。
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }

    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2) {return getKth(nums2, start2, end2, nums1, start1, end1, k);}
        if (len1 == 0) {return nums2[start2 + k - 1];}

        if (k == 1) {return Math.min(nums1[start1], nums2[start2]);}

        //比较位置索引
        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        //较小的部分将会被排除
        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        }
        else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }

}
