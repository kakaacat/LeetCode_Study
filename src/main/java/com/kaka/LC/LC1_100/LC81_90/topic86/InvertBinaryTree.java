package com.kaka.LC.LC1_100.LC81_90.topic86;

import com.kaka.LC.LC1_100.LC21_30.topic27.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

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

    /**
     * 迭代
     */
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return root;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            //交换左右节点
            TreeNode right = temp.right;
            temp.right = temp.left;
            temp.left = right;
            //左节点不为空
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            //右节点不为空
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }
        return root;
    }
}
