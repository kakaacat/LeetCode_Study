package com.kaka.LC.LC101_200.LC101_110.topic103;

/**
 * @Author : kaka
 * @Date: 2022-03-20 09:48
 *
 * @Description: 695. 岛屿的最大面积
 *
 * 给你一个大小为 m x n 的二进制矩阵 grid 。
 * 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。
 * 你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 *
 * 链接：https://leetcode-cn.com/problems/max-area-of-island
 */
public class MaxAreaOfIsland {
    /**
     * 深度优先搜素
     */
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                ans = Math.max(ans, dfs(grid, i, j));
            }
        }
        return ans;
    }

    private int dfs(int[][] grid, int curi, int curj) {
        if (curi < 0 || curj < 0 || curi >= grid.length || curj >= grid[0].length || grid[curi][curj] == 0) {
            return 0;
        }
        grid[curi][curj] = 0;
        return 1 + dfs(grid, curi - 1, curj)     //上
                 + dfs(grid, curi + 1, curj)     //下
                 + dfs(grid, curi, curj - 1)     //左
                 + dfs(grid, curi, curj + 1);    //右
    }
}
