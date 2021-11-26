package com.kaka.topic09;

import java.util.ResourceBundle;

/**
 * @Author : kaka
 * @Date: 2021-11-25 10:12
 *
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 -123 不是。
 *
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 */
public class PalindromeNumber {
    /**
     * 1.对半反转
     *
     * 时间复杂度：O(logn)，对于每次迭代，我们会将输入除以 10，因此时间复杂度为O(logn)。
     * 空间复杂度：O(1)。我们只需要常数空间存放若干变量。
     */
    public boolean isPalindrome(int x) {
        //特殊情况判断
        //小于零，最后一位为零
        if(x < 0 || x == 0 || x % 10 == 0){
            return false;
        }

        int reverseNum = 0;
        while (x > reverseNum) {
            reverseNum = reverseNum * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除
        return x == reverseNum || x == reverseNum / 10;
    }
}
