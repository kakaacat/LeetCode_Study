package com.kaka.LC101_200.LC121_130.topic125;

/**
 * @Author : kaka
 * @Date: 2022-04-12 09:43
 *
 * @Description: 剑指 Offer 10- II. 青蛙跳台阶问题
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 */
public class ForgJumpSteps {
    /**
     * 设跳上 n 级台阶有 f(n) 种跳法。在所有跳法中，青蛙的最后一步只有两种情况： 跳上 1 级或 2 级台阶。
     * 当为 1 级台阶： 剩 n−1 个台阶，此情况共有 f(n−1) 种跳法；
     * 当为 2 级台阶： 剩 n−2 个台阶，此情况共有 f(n-2)f(n−2) 种跳法。
     * f(n)为以上两种情况之和，即 f(n)=f(n-1)+f(n-2)，以上递推性质为斐波那契数列。本题可转化为 求斐波那契数列第 n 项的值
     * @param n
     * @return
     */
    public int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int f0 = 1, f1 = 1;
        int fn = 0;
        for (int i = 2; i <= n; i++) {
            fn = (f0 + f1) % 1000000007;
            f0 = f1;
            f1 = fn;
        }
        return fn;
    }
}
