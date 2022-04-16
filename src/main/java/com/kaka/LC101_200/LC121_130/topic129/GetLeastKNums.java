package com.kaka.LC101_200.LC121_130.topic129;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author : kaka
 * @Date: 2022-04-16 13:13
 *
 * @Description: 剑指 Offer 40. 最小的k个数
 *
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 */
public class GetLeastKNums {
    /**
     * 排序
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] ret = new int[k];
        Arrays.sort(arr);
        for (int i = 0; i < k; i++) {
            ret[i] = arr[i];
        }
        return ret;
    }

    /**
     * 堆
     */
    public int[] getLeastNumber2(int[] arr, int k) {
        int[] vec = new int[k];
        // 排除 0 的情况
        if (k == 0) {
            return vec;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        });
        for (int i = 0; i < k; ++i) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; ++i) {
            if (queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; ++i) {
            vec[i] = queue.poll();
        }
        return vec;
    }
}
