package com.kaka.LC61_70.topic65;

import com.kaka.LC21_30.topic27.TreeNode;
import javafx.scene.transform.Rotate;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author : kaka
 * @Date: 2022-02-01 20:10
 *
 * @Description: 113. 路径总和 II
 *
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 叶子节点 是指没有子节点的节点。
 *
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
 */
public class PathSumII {
    /**
     * dfs
     *
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(N)
     */
    List<List<Integer>> ret = new LinkedList<List<Integer>>();
    Deque<Integer> path = new LinkedList<Integer>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return ret;
    }

    private void dfs(TreeNode root, int targetSum) {
        if (root == null){
            return;
        }
        path.offerLast(root.val);
        targetSum -= root.val;

        if (root.left == null && root.right == null && targetSum == 0){
            ret.add(new LinkedList<Integer>(path));
        }

        dfs(root.left, targetSum);
        dfs(root.right, targetSum);

        path.pollLast();
    }
}
