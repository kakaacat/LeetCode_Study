package com.kaka.LC31_40.topic37;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : kaka
 * @Date: 2021-12-23 11:14
 *
 * @Description: 螺旋矩阵
 *
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 * https://leetcode-cn.com/problems/spiral-matrix/
 */
public class SpiralMatrix {
    /**
     * 1.按层
     *
     * 时间复杂度：O(mn)，其中 m 和 n 分别是输入矩阵的行数和列数。矩阵中的每个元素都要被访问一次。
     * 空间复杂度：O(1)。除了输出数组以外，空间复杂度是常数
     */
    public List<Integer> spiralOrder(int[][] matrix){
        List<Integer> order = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length, cols = matrix[0].length;
        int left = 0, right = cols - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            // 从左到右
            for (int c = left; c <= right; c++) {
                order.add(matrix[top][c]);
            }
            //从上到下
            for (int r = top + 1; r <= bottom; r++) {
                order.add(matrix[r][right]);
            }
            if (left < right && top < bottom) {
                //从右到左
                for (int c = right - 1; c > left ; c--) {
                    order.add(matrix[bottom][c]);
                }
                //从下到上
                for (int r = bottom; r > top; r--) {
                    order.add(matrix[r][left]);
                }
            }

            top++;
            left++;
            right--;
            bottom--;
        }

        return order;
    }
}
