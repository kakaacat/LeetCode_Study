package com.kaka.LC.LC1_100.LC1_10.topic06;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : kaka
 * @Date: 2021-11-22 14:55
 *
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 *
 */
public class ZigZagConversion {
    /**
     * 1.按行排序
     *
     * 通过从左向右迭代字符串，我们可以轻松地确定字符位于 Z 字形图案中的哪一行.
     *
     * 从左到右迭代 s，将每个字符添加到合适的行。字符添加位置一直都是递增或递减的。
     * 只有当我们向上移动到最上面的行或向下移动到最下面的行时，当前方向才会发生改变。
     *
     * 时间复杂度：O(n)，其中 n == len(s)
     * 空间复杂度：O(n)
     */
    public String convert1(String s, int numRows) {
        if(numRows < 2){
            return s;
        }

        //创建适当行数的表
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for (int i = 0; i < (Math.min(numRows, s.length())); i++) {
            rows.add(new StringBuilder());
        }

        int curRow = 0;
        int flag = -1;  // -1表示往上添加，1表示往下添加

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            //到第一行或者最后一行了改变方向
            if (curRow == 0 || curRow == numRows - 1){
                flag = -flag;
            }
            curRow += flag;
        }

        //最后的字符
        StringBuilder ans = new StringBuilder();
        for (StringBuilder row : rows) {
            ans.append(row);
        }

        return ans.toString();
    }

    /**
     * 2.按行访问
     *
     * 按照与逐行读取 Z 字形图案相同的顺序访问字符串。
     *
     * 对于所有整数 k:
     *      行 0中的字符位于索引k(2⋅numRows−2)处;
     *      行 numRows−1 中的字符位于索引 k(2⋅numRows−2)+numRows−1处;
     *      内部的行 i 中的字符位于索引k(2⋅numRows−2)+i 以及(k+1)(2⋅numRows−2)−i处;
     *
     * 时间复杂度：O(n)，其中 n==len(s)。每个索引被访问一次。
     * 空间复杂度：O(n)。
     */

    public String convert2(String s, int numRows) {
        if (numRows < 2){
            return s;
        }
        int len = s.length();
        int cycleLen = 2 * numRows - 2;

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < len; j += cycleLen) {
                ans.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < len){
                    ans.append(s.charAt(j + cycleLen - i));
                }
            }
        }

        return ans.toString();
    }

}
