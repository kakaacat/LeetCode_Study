package com.kaka.LC1_100.LC91_100.topic99;

import java.util.PriorityQueue;

/**
 * @Author : kaka
 * @Date: 2022-03-15 08:54
 *
 * @Description: 179. 最大数
 *
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 * 链接：https://leetcode-cn.com/problems/largest-number
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        PriorityQueue<String> heap = new PriorityQueue<>((x, y) -> (y + x).compareTo(x + y));
        for (int num : nums) {
            heap.offer(String.valueOf(num));
        }
        String res = "";
        while (heap.size() > 0) {
            res += heap.poll();
        }
        if (res.charAt(0) == '0') {
            return "0";
        }
        return res;
    }
}
