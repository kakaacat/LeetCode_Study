package com.kaka.LC.LC101_200.LC111_120.topic114;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author : kaka
 * @Date: 2022-03-31 10:20
 *
 * @Description: 402. 移掉 K 位数字
 *
 * 给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。
 * 请你以字符串形式返回这个最小的数字。
 *
 * https://leetcode-cn.com/problems/remove-k-digits/
 */
public class RemoveKDigit {
    public String removeKDigits(String num, int k) {
        Deque<Character> queue = new LinkedList<>();
        int len = num.length();
        for (int i = 0; i < len; i++) {
            char digit = num.charAt(i);
            while (!queue.isEmpty() && k > 0 && queue.peekLast() > digit) {
                queue.pollLast();
                k--;
            }
            queue.offerLast(digit);
        }

        for (int i = 0; i < k; i++) {
            queue.pollLast();
        }

        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        while (!queue.isEmpty()) {
            char digit = queue.pollFirst();
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            ret.append(digit);
        }

        return ret.length() == 0 ? "0" : ret.toString();
    }
}
