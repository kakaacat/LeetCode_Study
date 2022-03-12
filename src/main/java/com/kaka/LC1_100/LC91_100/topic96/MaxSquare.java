package com.kaka.LC1_100.LC91_100.topic96;

/**
 * @Author : kaka
 * @Date: 2022-03-12 09:39
 *
 * @Description: 221. 最大正方形
 *
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 *
 * https://leetcode-cn.com/problems/maximal-square/
 */
public class MaxSquare {
    /**
     * 暴力法
     */
    public int maxSquare(char[][] matrix) {
        int maxSide = 0;
        int row = matrix.length, col = matrix[0].length;
        if (matrix == null || row == 0 || col == 0) {
            return maxSide;
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 遇到一个 1 作为正方形的左上角
                if (matrix[i][j] == '1') {
                    maxSide = Math.max(maxSide, 1);

                    // 计算可能的最大正方形边长
                    int currMaxSide = Math.min(row - i, col - j);
                    for (int k = 1; k < currMaxSide; k++) {
                        // 判断新增的一行一列是否均为 1
                        boolean flag = true;
                        if (matrix[i + k][j + k] == '0') {
                            break;
                        }
                        for (int l = 0; l < k; l++) {
                            if (matrix[i + k][j + l] == '0' || matrix[i + l][j + k] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            maxSide = Math.max(maxSide, k + 1);
                        } else {
                            break;
                        }
                    }
                }
            }

            if ((row - 1 - i) <= maxSide) {
                break;
            }
        }

        return maxSide * maxSide;
    }


    /**
     * 动态规划
     */
    public int maxSquare2(char[][] matrix) {
        int maxSide = 0;
        int row = matrix.length, col = matrix[0].length;
        if (matrix == null || row == 0 || col == 0) {
            return maxSide;
        }

        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return maxSide * maxSide;
    }

}
