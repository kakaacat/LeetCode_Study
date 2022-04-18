package com.kaka.LC101_200.LC121_130.topic130;

/**
 * @Author : kaka
 * @Date: 2022-04-18 11:05
 *
 * @Description: 50. Pow(x, n)
 *
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn ）。
 *
 * https://leetcode-cn.com/problems/powx-n/
 */
public class Pow {
    /**
     * 递归
     */
    public double myPow(double x, int n) {
        int N = n;
        return N >= 0 ? pow(x, N) : 1.0 / pow(x, N);
    }

    private double pow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double y = pow(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }

    /**
     * 迭代
     */
    public double myPow2(double x, int n) {
        double ans = 1.0;

        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0) {
                ans *= x;
            }
            x *= x;
        }

        return n < 0 ? 1 / ans : ans;
    }
}
