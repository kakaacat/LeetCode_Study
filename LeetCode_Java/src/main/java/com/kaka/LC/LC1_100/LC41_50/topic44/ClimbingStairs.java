package com.kaka.LC.LC1_100.LC41_50.topic44;

/**
 * @Author : kaka
 * @Date: 2021-12-30 12:39
 *
 * @Description: 爬楼梯
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 *
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
public class ClimbingStairs {
    /**
     * 1.动态规划
     * f(x)=f(x−1)+f(x−2)
     *
     * 时间复杂度：循环执行 n 次，每次花费常数的时间代价，故渐进时间复杂度为 O(n)。
     * 空间复杂度：这里只用了常数个变量作为辅助空间，故渐进空间复杂度为 O(1)。
     */
    public int climbStairs(int n){
       int f0 = 1, f1 = 1, f = 1;
        for (int i = 2; i <= n; i++) {
            f = f0 + f1;
            f0 = f1;
            f1 = f;
        }
        return f;
    }
}
