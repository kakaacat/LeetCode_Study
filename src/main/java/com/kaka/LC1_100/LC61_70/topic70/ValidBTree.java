package com.kaka.LC1_100.LC61_70.topic70;

import com.kaka.LC1_100.LC21_30.topic27.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author : kaka
 * @Date: 2022-02-09 18:51
 *
 * @Description: 98. 验证二叉搜索树
 *
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效 二叉搜索树定义如下：
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *  
 *
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 */
public class ValidBTree {
    /**
     * 递归
     *
     * 时间复杂度 : O(n)
     * 空间复杂度 : O(n)
     */
    public boolean isValidBST(TreeNode root){
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long minValue, long maxValue) {
        if (root == null){
            return true;
        }

        if (root.val <= minValue || root.val >= maxValue){
            return false;
        }

        return isValidBST(root.left, minValue, root.val) && isValidBST(root.right, root.val, maxValue);
    }

    /**
     * 中序遍历
     *
     * 时间复杂度 : O(n)
     * 空间复杂度 : O(n)
     */
    public boolean isValidBST2(TreeNode root){
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= inorder){
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }

}
