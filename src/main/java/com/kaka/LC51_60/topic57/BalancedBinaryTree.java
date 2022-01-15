package com.kaka.LC51_60.topic57;

import com.kaka.LC21_30.topic27.TreeNode;

/**
 * @Author : kaka
 * @Date: 2022-01-12 19:24
 *
 * @Description: 110. 平衡二叉树
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 *
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root){
        return height(root) >= 0;
    }

    private int height(TreeNode root) {
        if (root == null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1){
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }

    }
}
