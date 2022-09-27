package com.kaka.LC.LC101_200.LC111_120.topic116;

import com.kaka.LC.LC1_100.LC21_30.topic27.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author : kaka
 * @Date: 2022-04-02 10:29
 *
 * @Description: 145. 二叉树的后序遍历
 *
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 *
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 */
public class BTreePostOrderTraversal {
    /**
     * dfs 递归
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        dfs(root, ret);
        return  ret;
    }

    private void dfs(TreeNode root, List<Integer> ret) {
        if (root == null) {
            return;
        }
        dfs(root.left, ret);
        dfs(root.right, ret);
        ret.add(root.val);
    }

    /**
     * 迭代
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }
}
