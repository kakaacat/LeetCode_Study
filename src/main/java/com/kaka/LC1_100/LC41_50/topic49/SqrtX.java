package com.kaka.LC1_100.LC41_50.topic49;

/**
 * @Author : kaka
 * @Date: 2022-01-04 11:02
 *
 * @Description: 69.x的平方根
 *
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 *
 * 链接：https://leetcode-cn.com/problems/sqrtx
 */
public class SqrtX {
    /**
     * 1、二分查找法
     *
     * 时间复杂度：O(logx)，即为二分查找需要的次数。
     * 空间复杂度：O(1)。
     */
    public int mySqrt(int x){
        int ans = -1;
        int l = 0, r = x;
        while (l <= r){
            int mid = (l + r) / 2;
            if ((long)mid * mid <= x){
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ans;
    }
    /**
     * 2、牛顿迭代
     */
    public int mySqrt2(int x){
        if (x == 0){
            return 0;
        }
        double c = x, x0 = x;
        while (true){
            double xi = 0.5 * (x0 + c / x0);
            if (Math.abs(x0 - xi) < 1E-7){
                break;
            }
            x0 = xi;
        }
        return (int) x0;
    }
}
