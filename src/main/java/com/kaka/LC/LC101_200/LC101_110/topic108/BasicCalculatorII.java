package com.kaka.LC.LC101_200.LC101_110.topic108;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author : kaka
 * @Date: 2022-03-25 15:07
 *
 * @Description: 227. 基本计算器 II
 *
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * 整数除法仅保留整数部分。
 * 你可以假设给定的表达式总是有效的。所有中间结果将在 [-231, 231 - 1] 的范围内。
 * 注意：不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
 *
 * 链接：https://leetcode-cn.com/problems/basic-calculator-ii。
 */
public class BasicCalculatorII {
    /**
     * 栈
     */
    public int calculator(String s) {
        Deque<Integer> stack = new LinkedList<>();
        char preSign = '+'; //第一个数为正数
        int num = 0;
        int len = s.length();
        //遍历字符串s
        for (int i = 0; i < len; i++) {
            //记录数字
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + (s.charAt(i) - '0');
            }
            //遇到符号 || 遍历到字符串的最后一位，数字入栈，并作相应的处理
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == len - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                }
                //记录当前的符号
                preSign = s.charAt(i);
                num = 0;
            }
        }

        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}
