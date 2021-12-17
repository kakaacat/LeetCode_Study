package com.kaka.LC31_40.topic31;

import java.security.PublicKey;

/**
 * @Author : kaka
 * @Date: 2021-12-17 09:56
 *
 * @Description: 并查集
 */
public class UnionFind {
    private int count;
    private int[] parent;
    private int[] rank;

    public UnionFind(char[][] grid) {
        this.count = 0;
        int m = grid.length;
        int n = grid[0].length;
        parent = new int[m * n];
        rank = new int[m * n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1'){
                    parent[i * n + j] = i * n + j;
                    ++count;
                }
                rank[i * n + j] = 0;
            }
        }
    }

    public int find(int x){
        if (parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y){
        int rootx = find(x);
        int rooty = find(y);
        if (rootx != rooty){
            if (rank[rootx] > rank[rooty]){
                parent[rooty] = rootx;
            }else if(rank[rootx] < rank[rooty]){
                parent[rootx] = rooty;
            }else{
                parent[rooty] = rootx;
                rank[rootx] += 1;
            }
            --count;
        }
    }
    public int getCount(){
        return this.count;
    }
}
