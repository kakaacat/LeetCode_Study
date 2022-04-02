package com.kaka.LC101_200.LC111_120.topic116;

import com.kaka.LC1_100.LC21_30.topic27.TreeNode;

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
     * dfs
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new LinkedList<>();
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
}
