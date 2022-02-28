package com.kaka.LC81_90.topic84;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author : kaka
 * @Date: 2022-02-28 10:11
 *
 * @Description: 169. 多数元素
 *
 * 给定一个大小为 n 的数组，找到其中的多数元素。
 * 多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 链接：https://leetcode-cn.com/problems/majority-element
 */
public class MajorityElement {
    /**
     * 排序
     *
     * 时间复杂度：O(nlogn)。将数组排序的时间复杂度为O(nlogn)。
     * 空间复杂度：O(logn)。如果使用语言自带的排序算法，
     * 需要使用O(logn) 的栈空间。如果自己编写堆排序，则只需要使用 O(1) 的额外空间。
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 哈希表
     */
    public int majorityElement2(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > len / 2) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
