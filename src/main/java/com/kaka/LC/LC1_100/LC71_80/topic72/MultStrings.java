package com.kaka.LC.LC1_100.LC71_80.topic72;

/**
 * @Author : kaka
 * @Date: 2022-02-15 12:37
 *
 * @Description: 43. 字符串相乘
 *
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
 *
 * 链接：https://leetcode-cn.com/problems/multiply-strings
 */
public class MultStrings {
    /**
     * 时间复杂度：O(mn)
     * 空间复杂度：O(m+n)
     */
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length(), n = num2.length();
        int[] ansArr = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0 ; j--) {
                int y = num2.charAt(j) - '0';
                ansArr[n + m + 1] += x * y;
            }
        }

        for (int i = m + n - 1; i > 0; i--) {
            ansArr[i - 1] += ansArr[i] / 10;
            ansArr[i] %= 10;
        }

        int index = ansArr[0] == 0? 1 : 0;
        StringBuffer ans = new StringBuffer();
        while (index < m + n) {
            ans.append(ansArr[index]);
            index++;
        }
        return ans.toString();
    }
}
