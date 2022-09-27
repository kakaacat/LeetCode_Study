package com.kaka.LC.LC1_100.LC41_50.topic48;

import com.kaka.LC.LC1_100.LC21_30.topic27.TreeNode;

/**
 * @Author : kaka
 * @Date: 2022-01-03 14:01
 *
 * @Description: 124. 二叉树中的最大路径和
 *
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。
 * 同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 *
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 */
public class BinaryTreeMaximumPathSum {
    /**
     * 递归
     *
     * 二叉树 abc，a 是根结点（递归中的 root），bc 是左右子结点（代表其递归后的最优解）。
     * 最大的路径，可能的路径情况：
     * b + a + c。
     * b + a + a 的父结点。
     * a + c + a 的父结点。
     * 其中情况 1，表示如果不联络父结点的情况，或本身是根结点的情况。
     * 这种情况是没法递归的，但是结果有可能是全局最大路径和。
     * 情况 2 和 3，递归时计算 a+b 和 a+c，选择一个更优的方案返回，也就是上面说的递归后的最优解啦。
     * 另外结点有可能是负值，最大和肯定就要想办法舍弃负值（max(0, x)）（max(0,x)）。
     * 但是上面 3 种情况，无论哪种，a 作为联络点，都不能够舍弃。
     *
     * 时间复杂度：O(N)，其中 N 是二叉树中的节点个数。对每个节点访问不超过 2 次。
     *
     * 空间复杂度：O(N)，其中 N 是二叉树中的节点个数。
     * 空间复杂度主要取决于递归调用层数，最大层数等于二叉树的高度，最坏情况下，二叉树的高度等于二叉树中的节点个数
     */
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root){
        maxGain(root);
        return maxSum;
    }

    private  int maxGain(TreeNode root) {
        if (root == null){
            return 0;
        }

        //左右节点的值
        int leftSum = Math.max(maxGain(root.left), 0);
        int rightSum = Math.max(maxGain(root.right), 0);

        //节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        int rootSum = root.val + leftSum + rightSum;

        maxSum = Math.max(maxSum, rootSum);

        return root.val + Math.max(leftSum, rightSum);
    }
}
