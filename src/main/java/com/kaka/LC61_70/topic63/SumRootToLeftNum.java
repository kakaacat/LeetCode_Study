package com.kaka.LC61_70.topic63;

import com.kaka.LC21_30.topic27.TreeNode;

/**
 * @Author : kaka
 * @Date: 2022-01-30 20:08
 *
 * @Description: 129. 求根节点到叶节点数字之和
 *
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * 叶节点 是指没有子节点的节点。
 *
 * 链接：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers
 */
public class SumRootToLeftNum {
    /**
     * dfs
     *
     * 时间复杂度：O(n)，其中 n 是二叉树的节点个数。对每个节点访问一次。
     * 空间复杂度：O(n)，其中 n 是二叉树的节点个数。空间复杂度主要取决于递归调用的栈空间，
     * 递归栈的深度等于二叉树的高度，最坏情况下，二叉树的高度等于节点个数，空间复杂度为 O(n)。
     */
    public int sumNumbers(TreeNode root){
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int prevNum) {
        if (root == null){
            return 0;
        }

        int sum = prevNum * 10 + root.val;
        if (root.left == null && root.right == null){
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }
}
