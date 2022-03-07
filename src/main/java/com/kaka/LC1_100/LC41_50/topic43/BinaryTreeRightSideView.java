package com.kaka.LC1_100.LC41_50.topic43;

import com.kaka.LC1_100.LC21_30.topic27.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author : kaka
 * @Date: 2021-12-29 14:48
 *
 * @Description: 二叉树的右视图
 *
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/
 */
public class BinaryTreeRightSideView {
    /**
     * 1.广度优先搜索
     */
    public List<Integer> rightSideView(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
                //每一层最右边的结点
                if (i == size - 1){
                    res.add(node.val);
                }
            }
        }

        return res;
    }
    /**
     * 2.深度优先搜索
     */
    public List<Integer> rightSideView2(TreeNode root){
        List<Integer> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }
    //深度优先搜索。按根右左的顺序
    private void dfs(TreeNode root, int depth, List<Integer> res) {
        if (root == null){
            return;
        }
        //每一层最右边的结点
        if (depth == res.size()){
            res.add(root.val);
        }
        depth++;
        dfs(root.right, depth, res);
        dfs(root.left, depth, res);
    }
}
