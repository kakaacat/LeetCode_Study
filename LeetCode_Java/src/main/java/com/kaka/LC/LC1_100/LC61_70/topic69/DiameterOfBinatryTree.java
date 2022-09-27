package com.kaka.LC.LC1_100.LC61_70.topic69;

import com.kaka.LC.LC1_100.LC21_30.topic27.TreeNode;

/**
 * @Author : kaka
 * @Date: 2022-02-08 18:11
 *
 * @Description: 543. 二叉树的直径
 *
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
 * 这条路径可能穿过也可能不穿过根结点。
 *
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 */
public class DiameterOfBinatryTree {
    int ans = 0;
    public int diameterOfBinatryTree(TreeNode root){
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null){
            return 0;
        }

        int L = dfs(root.left);
        int R = dfs(root.right);

        ans = Math.max(L + R, ans);

        return Math.max(L, R) + 1;
    }
}
