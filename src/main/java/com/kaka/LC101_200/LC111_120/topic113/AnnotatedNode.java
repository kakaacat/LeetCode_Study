package com.kaka.LC101_200.LC111_120.topic113;

import com.kaka.LC1_100.LC21_30.topic27.TreeNode;

/**
 * @Author : kaka
 * @Date: 2022-03-30 15:25
 */
public class AnnotatedNode {
    public TreeNode node;
    public int pos;
    public int depth;

    public AnnotatedNode(TreeNode node, int pos, int depth) {
        this.node = node;
        this.pos = pos;
        this.depth = depth;
    }
}
