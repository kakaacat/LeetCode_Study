package com.kaka.LC1_100.LC91_100.topic91;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @Author : kaka
 * @Date: 2022-03-07 10:13
 *
 * @Description: 136. 只出现一次的数字
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 链接：https://leetcode-cn.com/problems/single-number
 */
public class SingleNum {
    /**
     * 位运算
     */
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

    /**
     * hashset
     */
    public int singleNum(int[] nums) {
        int ans = 0;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (!hashSet.add(num)) {
                hashSet.remove(num);
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ans = (int) it.next();
        }
        return ans;
    }


}
