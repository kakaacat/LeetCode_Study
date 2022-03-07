package com.kaka.LC1_100.LC1_10.topic07;

/**
 * @Author : kaka
 * @Date: 2021-11-23 10:14
 *
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * -2^31 <= x <= 2^31 - 1
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 */
public class ReverseInteger {
    /**
     * 1.取模运算
     * 时间复杂度：O(log∣x∣)。翻转的次数即 x十进制的位数。
     * 空间复杂度：O(1)。
     */
    public int reverse1(int x) {
        int res = 0;
        int temp = 0;
        while(x != 0){
            //判断是否越界，2^31 - 1 = 2147483647;−2^31 = -2147483648

//            //res已经大于214748364 或者 等于214748364但最后一位大于7
//            if(res > 214748364 || (res == 214748364 && temp > 7)){
//                    return 0;
//            }
//            //res已经小于214748364 或者 等于-214748364但最后一位小于-8
//            if (res < -214748364 || (res == -214748364 && temp < -8)){
//                return 0;
//            }

            //当 res == 214748364时， x的位数与INT_MAX 的位数相同,且要推入的数字 digit 为 x的最高位。
            //由于 x不超过 INT_MAX，因此 digit 不会超过 INT_MAX 的最高位，即 digit 小于等于 2；
            //所以没有必要进行 res == 214748364 && temp > 7 的判断
            if(res < Integer.MIN_VALUE / 10 || res > Integer.MAX_VALUE / 10){
                return 0;
            }
            //取末尾数
            temp = x % 10;
            x /= 10;
            res = res * 10 + temp;
        }

        return res;
    }

    /**
     * 2.反转字符串
     */
    public int reverse2(int x) {
        String xString = Integer.toString(x);
        String string = xString;
        int flag = 1;
        if (x < 0) {
            flag = -1;
            string = xString.substring(1);
        }
        try {
            return Integer.valueOf((new StringBuilder(string)).reverse().toString()) * flag;
        }catch (Exception e){
            return 0;
        }
    }
}
