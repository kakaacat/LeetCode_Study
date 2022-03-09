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
     *
     * 时间复杂度：O(mn)。
     * 空间复杂度：O(1)。
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

    /**
     * 每行二分查找
     *
     * 时间复杂度：O(mlogn)。
     * 空间复杂度：O(1)。
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        for (int[] row : matrix) {
            int index = binarySearch(row, target);
            if (index >= 0 && index < row.length) {
                return true;
            }
        }
        return false;
    }

    public int binarySearch(int[] row, int target) {
        int l = 0, r = row.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (target == row[mid]) {
                return mid;
            } else if (target > row[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 从右上角z字形查找
     *
     * 时间复杂度：O(m+n)。
     * 空间复杂度：O(1)。
     */
    public boolean searchMatrix3(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int x = 0, y = n - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] > target) {
                y--;
            } else {
                x++;
            }
        }
        return false;
    }
}
