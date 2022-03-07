package com.kaka.LC1_100.LC31_40.topic31;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author : kaka
 * @Date: 2021-12-16 21:20
 *
 * @Description: 岛屿数量
 *
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 */
public class NumberOfIslands {
    /**
     * 1.深度优先搜索
     *
     *
     * 时间复杂度：O(MN)，其中 M 和 N 分别为行数和列数。
     * 空间复杂度：O(MN)，在最坏情况下，整个网格均为陆地，深度优先搜索的深度达到 MN。
     */
    private void dfs(char[][] grid, int r, int c){
        //行数
        int nr = grid.length;
        //列数
        int nc = grid[0].length;

        //越界 或者 遇到 0 就停止
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0'){
            return;
        }

        //访问过的就置为 0
        grid[r][c] = '0';

        //搜索这个格子的上、下、左、右
        dfs(grid, r - 1,  c);
        dfs(grid, r + 1,  c);
        dfs(grid, r,  c - 1);
        dfs(grid, r,  c + 1);
        //所有的搜索完就代表 一个岛屿
    }
    public int numIslands1(char[][] grid){
        if (grid == null){
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int islandsNum = 0;
        for (int  r = 0; r < nr; r++){
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == '1'){
                    ++islandsNum;
                    dfs(grid, r, c);
                }
            }
        }
        return islandsNum;
    }

    /**
     * 2.广度优先搜索
     */
    public int numsIslands2(char[][] grid){
        if (grid == null){
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int islandsNum = 0;
        

        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == '1'){
                    ++islandsNum;
                    grid[r][c] = '0';
                    Queue<Integer> neighbers = new LinkedList<Integer>();
                    neighbers.add(r * nc + c);
                    while (!neighbers.isEmpty()){
                        int id = neighbers.remove();
                        int row = id / nc;
                        int col = id % nc;
                        //上
                        if (row - 1 >= 0 && grid[row-1][col] == '1'){
                            neighbers.add((row-1) * nc + col);
                            grid[row-1][col] = '0';
                        }
                        //下
                        if (row + 1 < nr && grid[row+1][col] == '1'){
                            neighbers.add((row+1) * nc + col);
                            grid[row+1][col] = '0';
                        }
                        //左
                        if (col - 1 >= 0 && grid[row][col-1] == '1'){
                            neighbers.add(row * nc + col-1);
                            grid[row][col-1] = '0';
                        }
                        //右
                        if (col + 1 < nc && grid[row][col+1] == '1'){
                            neighbers.add(row * nc + col+1);
                            grid[row][col+1] = '0';
                        }
                    }
                }
            }
        }

        return islandsNum;
    }

    /**
     * 2.并查集
     */


    public int numsIslands(char[][] grid){
        if (grid == null) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        UnionFind uf = new UnionFind(grid);
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    grid[r][c] = '0';
                    if (r + 1 < nr && grid[r+1][c] == '1') {
                        uf.union(r * nc + c, (r+1) * nc + c);
                    }
                    if (c + 1 < nc && grid[r][c+1] == '1') {
                        uf.union(r * nc + c, r * nc + c + 1);
                    }
                }
            }
        }
        return uf.getCount();
    }
}
