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

    /**
     * 矩阵快速幂
     */
    public int fib2(int n) {
        if (n < 2) {
            return n;
        }

        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = pow(q, n - 1);
        return res[0][0];
    }

    private int[][] pow(int[][] q, int n) {
        int[][] ret = {{1, 0}, {0, 1}};

        while (n > 0) {
            //若为奇数，需要多乘一次q
            if ((n & 1) == 1) {
                ret = multiply(ret, q);
            }

            //奇次偶次除后都一样
            n >>= 1;
            q = multiply(q, q);
        }

        return ret;
    }

    private int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = (int) (((long)a[i][0] * b[0][j] + (long) a[i][1] * b[1][j]) % 1000000007);
            }
        }

        return c;
    }
}
