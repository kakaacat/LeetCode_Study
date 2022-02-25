package com.kaka.LC81_90.topic81;

/**
 * @Author : kaka
 * @Date: 2022-02-25 10:08
 *
 * @Description: 48. 旋转图像
 *
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *
 * 链接：https://leetcode-cn.com/problems/rotate-image
 */
public class RotateImage {
    /**
     * 翻转代替旋转
     *
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(1)
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        //水平翻转
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = temp;
            }
        }

        //主对角线翻转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

}
