package com.kaka.LC.LC101_200.LC121_130.topic128;

/**
 * @Author : kaka
 * @Date: 2022-04-15 17:03
 *
 * @Description: 59. 螺旋矩阵 II
 *
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 * https://leetcode-cn.com/problems/spiral-matrix-ii/
 */
public class SpiralMatrixII {
    //模拟
    public int[][] generateMatrix(int n) {
        int maxNum = n * n;
        int curNum = 1;
        int[][] matrix = new int[n][n];
        int row = 0, col = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1 ,0}};    //右下左上
        int directionIndex = 0;
        while (curNum <= maxNum) {
            matrix[row][col] = curNum;
            curNum++;
            int newRow = row + directions[directionIndex][0];
            int newCol = col + directions[directionIndex][1];
            if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= n || matrix[newRow][newCol] != 0) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            col += directions[directionIndex][1];
        }

        return matrix;
    }
}
