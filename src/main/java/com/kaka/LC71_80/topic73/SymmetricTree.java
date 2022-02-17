package com.kaka.LC71_80.topic73;

import com.kaka.LC21_30.topic27.TreeNode;

/**
 * @Author : kaka
 * @Date: 2022-02-17 14:18
 *
 * @Description: 101. 对称二叉树
 *
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 *
 * https://leetcode-cn.com/problems/symmetric-tree/
 */
public class SymmetricTree {
    /**
     * 递归
     *
     * 时间复杂度为 O(n)
     * 空间复杂度为 O(n)
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        } else {
            return check(root.left, root.right);
        }
    }

    private boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null){
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }
}
