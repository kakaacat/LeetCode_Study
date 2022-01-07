package com.kaka.LC51_60.topic52;

import com.kaka.LC21_30.topic27.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : kaka
 * @Date: 2022-01-07 14:09
 *
 * @Description: 144. 二叉树的前序遍历
 *
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 *
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class BinaryTreePreorderTraversal {
    /**
     * 递归
     */

    List<Integer> res = new ArrayList<Integer>();
    public List<Integer> preorderTraversal(TreeNode root){
        preorder(root);
        return res;
    }

    private void preorder(TreeNode root) {
        if (root == null){
            return;
        }

        res.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }
}
