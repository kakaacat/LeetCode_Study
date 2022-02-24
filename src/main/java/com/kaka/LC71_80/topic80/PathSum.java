package com.kaka.LC71_80.topic80;

import com.kaka.LC21_30.topic27.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author : kaka
 * @Date: 2022-02-24 12:57
 *
 * @Description: 112. 路径总和
 *
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。
 * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
 * 如果存在，返回 true ；否则，返回 false 。
 * 叶子节点 是指没有子节点的节点。
 *
 * 链接：https://leetcode-cn.com/problems/path-sum
 */
public class PathSum {
    /**
     * 递归dfs
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }


}
