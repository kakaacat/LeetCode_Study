package com.kaka.LC1_10.day01;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : kaka
 * @Date: 2021-11-17 16:51
 *
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 * 链接：https://leetcode-cn.com/problems/two-sum/
 * 来源：力扣（LeetCode）
 */
public class TwoSum {

    /**
     * 方法一：暴力枚举
     */

    public int[] twoSum01(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if((nums[i] + nums[j]) == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }


    /** 方法二：哈希表
    *思路及算法
    *使用哈希表，可以将寻找 target - x 的时间复杂度降低到从 O(N)降低到 O(1)。
    *这样我们创建一个哈希表，对于每一个 x，我们首先查询哈希表中是否存在 target - x
    *然后将 x 插入到哈希表中，即可保证不会让 x 和自己匹配。
    *
    */


    public int[] twoSum02(int[] nums, int target){
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++){
            if (hashMap.containsKey(target - nums[i])){
                return new int[]{hashMap.get(target - nums[i]), i};
            }
            hashMap.put(nums[i], i);
        }
        return new int[0];
    }
}
