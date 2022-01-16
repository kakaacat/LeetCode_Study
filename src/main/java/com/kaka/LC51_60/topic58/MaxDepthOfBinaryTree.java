package com.kaka.LC51_60.topic58;

import com.kaka.LC21_30.topic27.TreeNode;

/**
 * @Author : kaka
 * @Date: 2022-01-16 20:15
 *
 * @Description: 104. 二叉树的最大深度
 *
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class MaxDepthOfBinaryTree {
    /**
     * dfs
     */
    public int maxDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    /**
     * 
     */
}
