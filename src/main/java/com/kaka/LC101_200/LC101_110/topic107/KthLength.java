package com.kaka.LC101_200.LC101_110.topic107;

import com.kaka.LC1_100.LC21_30.topic27.TreeNode;

/**
 * @Author : kaka
 * @Date: 2022-03-24 09:29
 *
 * @Description: 剑指 Offer 54. 二叉搜索树的第k大节点
 *
 * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
 *
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 */
public class KthLength {
    /**
     * 中序遍历的逆序-->右根左
     */
    int res, k;
    public int kthLength(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        if (k == 0) {
            return;
        }
        if (--k == 0) {
            res = root.val;
        }

        dfs(root.left);
    }
}
