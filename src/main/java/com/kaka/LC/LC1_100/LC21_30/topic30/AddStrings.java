package com.kaka.LC.LC1_100.LC21_30.topic30;

/**
 * @Author : kaka
 * @Date: 2021-12-15 19:10
 *
 * @Description: 字符串相加
 *
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 *
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 *
 * 链接：https://leetcode-cn.com/problems/add-strings
 */
public class AddStrings {
    private int toInt(String num, int len){
        int l = len;
        int intNum;
        int result = 0;
        double v;
        for (int i = 0; i < len; i++) {
            intNum = num.charAt(i) - '0';
            v = intNum * Math.pow(10, --l);
            result += v;
        }
        return result;
    }
    public String addStrings1(String num1, String num2){
        int num1Int = toInt(num1, num1.length());
        int num2Int = toInt(num2, num2.length());

        Integer ans = num1Int + num2Int;
        return ans.toString();
    }

    /**
     *
     */

    public String addStrings(String num1, String num2){
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        int num1Int;
        int num2Int;
        int add = 0;
        StringBuffer ans = new StringBuffer();

        while (len1 >= 0 || len2 >= 0 || add != 0){
            num1Int = len1 >= 0 ? num1.charAt(len1--) - '0' : 0;
            num2Int = len2 >= 0 ? num2.charAt(len2--) - '0' : 0;
            add += num1Int + num2Int;
            if (add >= 10){
                ans.append(add % 10);
                add = add /10;
            }else{
                ans.append(add);
                add = 0;
            }
        }
        return ans.reverse().toString();
    }
}
