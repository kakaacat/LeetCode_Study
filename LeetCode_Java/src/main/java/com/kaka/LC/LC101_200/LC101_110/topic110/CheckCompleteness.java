package com.kaka.LC.LC101_200.LC101_110.topic110;

import com.kaka.LC.LC1_100.LC21_30.topic27.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : kaka
 * @Date: 2022-03-27 11:34
 *
 * @Description: 958. 二叉树的完全性检验
 *
 * 给定一个二叉树的 root ，确定它是否是一个 完全二叉树 。
 * 在一个 完全二叉树 中，除了最后一个关卡外，所有关卡都是完全被填满的，
 * 并且最后一个关卡中的所有节点都是尽可能靠左的。它可以包含 1 到 2h 节点之间的最后一级 h 。
 *
 * 链接：https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree
 */
public class CheckCompleteness {
    public boolean isCompleteTree(TreeNode root) {
        List<ANode> list = new ArrayList<ANode>();
        list.add(new ANode(root, 1));
        for (int i = 0; i < list.size(); i++) {
            ANode aNode = list.get(i);
            if (aNode.node != null) {
                list.add(new ANode(aNode.node.left, 2 * aNode.code));
                list.add(new ANode(aNode.node.right, 2 * aNode.code + 1));
            }
        }

        return list.get(list.size() - 1).code == list.size();
    }
}
