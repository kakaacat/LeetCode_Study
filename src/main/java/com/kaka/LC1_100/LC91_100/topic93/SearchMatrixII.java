package com.kaka.LC1_100.LC91_100.topic93;

/**
 * @Author : kaka
 * @Date: 2022-03-09 09:23
 *
 * @Description: 240. 搜索二维矩阵 II
 *
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *  
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii
 */
public class SearchMatrixII {
    /**
     * 直接搜素
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] row : matrix) {
            for (int num : row) {
                if (num == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
