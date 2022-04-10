package com.kaka.LC101_200.LC121_130.topic123;

/**
 * @Author : kaka
 * @Date: 2022-04-10 10:26
 *
 * @Description: 剑指 Offer 10- I. 斐波那契数列
 *
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof。
 */
public class Fibonacci {
    /**
     * 动态规划
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        final int MOD = 1000000007;
        int f0 = 0, f1 = 1;
        int fn = 0;
        for (int i = 2; i <= n; i++) {
            fn = (f1 + f0) % MOD;
            f0 = f1;
            f1 = fn;
        }
        return fn;
    }
}
