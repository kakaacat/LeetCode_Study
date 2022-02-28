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

    /**
     * 随机化
     */
    public int majorityElement3(int[] nums) {
        while (true) {
            int rand = (int) (Math.random() * nums.length);
            int count = 0;
            for (int num : nums) {
                if (num == nums[rand]) {
                    count++;
                }
                if (count > nums.length / 2) {
                    return nums[rand];
                }
            }
        }
    }

    /**
     * 摩尔投票法思路
     * 候选人(cand_num)初始化为nums[0]，票数count初始化为1。
     * 当遇到与cand_num相同的数，则票数count = count + 1，否则票数count = count - 1。
     * 当票数count为0时，更换候选人，并将票数count重置为1。
     * 遍历完数组后，cand_num即为最终答案。
     * <p>
     * 为何这行得通呢？
     * 投票法是遇到相同的则票数 + 1，遇到不同的则票数 - 1。
     * 且“多数元素”的个数> ⌊ n/2 ⌋，其余元素的个数总和<= ⌊ n/2 ⌋。
     * 因此“多数元素”的个数 - 其余元素的个数总和 的结果 肯定 >= 1。
     * 这就相当于每个“多数元素”和其他元素 两两相互抵消，抵消到最后肯定还剩余至少1个“多数元素”。
     * <p>
     * 无论数组是1 2 1 2 1，亦或是1 2 2 1 1，总能得到正确的候选人。
     */
    public int majorityElement4(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
}
