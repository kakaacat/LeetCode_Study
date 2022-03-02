package com.kaka.LC81_90.topic86;

import com.kaka.LC21_30.topic27.TreeNode;

/**
 * @Author : kaka
 * @Date: 2022-03-02 09:16
 *
 * @Description: 226. 翻转二叉树
 *
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 *
 * https://leetcode-cn.com/problems/invert-binary-tree/
 */
public class InvertBinaryTree {
    /**
     * 递归
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = invertTree(root.right);
        TreeNode right = invertTree(root.left);
        root.left = left;
        root.right = right;
        return root;
    }
}
