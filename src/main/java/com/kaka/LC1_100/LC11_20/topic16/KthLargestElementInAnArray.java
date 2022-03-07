package com.kaka.LC1_100.LC11_20.topic16;

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

    /**
     * 3、堆排序(大根堆)
     */
    public int findKthLargest3(int nums[], int k){
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        //建堆完毕后，nums【0】为最大元素。逐个删除堆顶元素，直到删除了k-1个。
        for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
            //先将堆的最后一个元素与堆顶元素交换，由于此时堆的性质被破坏，需对此时的根节点进行向下调整操作。
            swap(nums, i, 0);
            --heapSize;     //相当于删除了最大值
            maxHeapify(nums, 0, heapSize);  //重新排序找出最大值
        }

        return nums[0];
    }

    //建立一个大根堆
    private void buildMaxHeap(int[] nums, int heapSize){
        //从最后一个父节点位置开始调整每一个节点的子树。
        //数组长度为heapsize，因此最后一个节点的位置为heapsize-1，所以父节点的位置为heapsize-1-1/2。
        for (int i = (heapSize-2)/ 2; i >= 0; --i) {
            maxHeapify(nums, i, heapSize);
        }
    }
    //调整当前结点和子节点的顺序。i:需要调整的节点
    public void maxHeapify(int[] nums, int i, int heapSize) {
        //left和right表示当前父节点i的两个左右子节点。
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int largest = i;    //最大值指针
        //如果左子点在数组内，且比当前父节点大，则将最大值的指针指向左子点。
        if(left < heapSize && nums[left] > nums[largest]){
            largest = left;
        }
        //如果右子点在数组内，且比当前父节点大，则将最大值的指针指向右子点。
        if(right < heapSize && nums[right] > nums[largest]){
            largest = right;
        }
        //如果最大值的指针不是父节点，则交换父节点和当前最大值指针指向的子节点。
        if(largest != i){
            swap(nums, i, largest);
            //由于交换了父节点和子节点，因此可能对子节点的子树造成影响，所以对子节点的子树进行调整。
            maxHeapify(nums, largest, heapSize);
        }
    }
}
