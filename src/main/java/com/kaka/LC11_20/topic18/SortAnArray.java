package com.kaka.LC11_20.topic18;

import java.util.Random;

/**
 * @Author : kaka
 * @Date: 2021-12-04 16:16
 *
 * 排序数组-手撕快排、堆排序
 * 给你一个整数数组 nums，请你将该数组升序排列。
 *
 * 示例 1：
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 *
 * 链接：https://leetcode-cn.com/problems/sort-an-array
 */
public class SortAnArray {
    public int[] sortArray1(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
    /**
     * 快排
     * 时间复杂度：O(NlogN)
     */
    private static Random roman = new Random(System.currentTimeMillis());
    private void quickSort(int[] nums, int left, int right){
        if (left < right){
            int part = partition(nums, left, right);
            quickSort(nums, left, part - 1);
            quickSort(nums, part + 1, right);
        }
    }
    private int partition(int[] nums, int left, int right) {
        if (right > left) {
            //[left, right+1)范围的随机数
            int ranIndex = roman.nextInt(right - left) + 1 + left;
            swap(nums, left, ranIndex);
        }

        int pivot = nums[left];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] <= pivot) {
                swap(nums, ++j, i);
            }
        }
        swap(nums, j, left);
        return j;
    }
    private void swap(int[] nums, int i, int j) {
        int temp;
        temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    //=================================
    public int[] sortArray(int[] nums) {
        heapSort(nums);
        return nums;
    }
    /**
     * 堆排序
     * 时间复杂度：O(NlogN)
     */
    private void heapSort(int[] nums){
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        for (int i = heapSize - 1; i >= 0 ; i--) {
            swap(nums, i, 0);     //把最大值放到最后
            heapSize--;  //堆的大小减 1
            maxHeapify(nums, 0, heapSize);   //重新调整堆
        }
    }

    //建堆
    private void buildMaxHeap(int[] nums, int heapSize){
        //从最后一个父节点开始调整
        for (int i = heapSize / 2; i >= 0; i--) {
            maxHeapify(nums, i, heapSize);
        }
    }
    //调整
    private void maxHeapify(int[] nums, int parent, int heapSize) {
        //两个子节点
        int left = parent * 2 + 1;
        int right = parent * 2 + 2;
        int largest = parent;
        //找出最大值
        /*一定要把left与right是否在heapSize范围内的判断放在前面*/
        if (left < heapSize && nums[left] > nums[largest]){
            largest = left;
        }
        if (right < heapSize && nums[right] > nums[largest]){
            largest = right;
        }
        //交换位置，使最大值为父节点
        if (largest != parent){
            swap(nums, largest, parent);
            //由于交换了父节点和子节点，因此可能对子节点的子树造成影响，所以对子节点的子树进行调整。
            maxHeapify(nums, largest, heapSize);
        }
    }
}
