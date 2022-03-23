package com.kaka.LC101_200.LC101_110.topic106;


/**
 * @Author : kaka
 * @Date: 2022-03-23 09:44
 *
 * @Description: 剑指 Offer 36. 二叉搜索树与双向链表
 *
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
 * 要求不能创建任何新的节点，只能调整树中节点指针的指向。
 *
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 */
public class TreeToDoublyList {
    /**
     * 中序
     */
    Node head, prev;
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        prev.right = head;
        head.left = prev;
        return head;
    }

    private void dfs(Node root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (prev == null) {
            prev = root;
            head = root;
        } else {
            prev.right = root;
            root.left = prev;
            prev = root;
        }
        dfs(root.right);
    }
}
