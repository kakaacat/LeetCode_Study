package com.kaka.LC101_200.LC111_120.topic113;

import com.kaka.LC1_100.LC21_30.topic27.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author : kaka
 * @Date: 2022-03-30 15:06
 *
 * @Description: 662. 二叉树最大宽度
 * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。
 * 这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 *
 * 链接：https://leetcode-cn.com/problems/maximum-width-of-binary-tree
 */
public class MaxWidthOfBTree {
    public int widthOfBinaryTree(TreeNode root) {
        Deque<AnnotatedNode> queue = new LinkedList<>();
        queue.add(new AnnotatedNode(root, 0, 0));
        int curDepth = 0, left = 0, ans =0;
        while (!queue.isEmpty()) {
            AnnotatedNode annotatedNode = queue.poll();
            if (annotatedNode.node != null) {
                queue.add(new AnnotatedNode(annotatedNode.node.left, annotatedNode.depth + 1, annotatedNode.pos * 2));
                queue.add(new AnnotatedNode(annotatedNode.node.right, annotatedNode.depth + 1,
                        annotatedNode.pos * 2 + 1));
                if (curDepth != annotatedNode.depth) {
                    curDepth = annotatedNode.depth;
                    left = annotatedNode.pos;
                }
                ans = Math.max(ans, annotatedNode.pos - left + 1);
            }
        }
        return ans;
    }
}
