package com.kaka.LC101_200.LC111_120.topic117;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author : kaka
 * @Date: 2022-04-03 16:58
 *
 * @Description: 498. 对角线遍历
 *
 * 给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
 *
 * https://leetcode-cn.com/problems/diagonal-traverse/
 */
public class DiagonalTraversal {
    /**
     * 对角线迭代和翻转
     * @param mat
     * @return
     */
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        if (mat == null || mat.length == 0) {
            return new int[0];
        }

        int[] result = new int[n * m];
        int k = 0;
        List<Integer> intermediate = new ArrayList<>();

        for (int d = 0; d < n + m - 1; d++) {
            intermediate.clear();

            int r = d < m ? 0 : d - m + 1;
            int c = d < m ? d : m - 1;

            while (r < n && c > -1) {
                intermediate.add(mat[r][c]);
                r++;
                c--;
            }

            if (d % 2 == 0) {
                Collections.reverse(intermediate);
            }

            for (int i = 0; i < intermediate.size(); i++) {
                result[k++] = intermediate.get(i);
            }
        }

        return result;
    }
}
