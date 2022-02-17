package com.kaka.LC71_80.topic73;

import com.kaka.LC21_30.topic27.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

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

    /**
     * 迭代
     */
    public boolean isSymme(TreeNode root) {
        if (root == null || (root.right == null && root.left == null)) {
            return true;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()) {
            TreeNode left = queue.pollFirst();
            TreeNode right = queue.pollFirst();
            if (left == null && right == null){
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }

            queue.add(left.left);
            queue.add(right.right);

            queue.add(left.right);
            queue.add(right.left);
        }

        return true;
    }
}
