package com.kaka.LC.LC1_100.LC51_60.topic55;

import com.kaka.LC.LC1_100.LC21_30.topic27.TreeNode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Author : kaka
 * @Date: 2022-01-10 15:23
 *
 * @Description: 105. 从前序与中序遍历序列构造二叉树
 *
 * 给定一棵树的前序遍历 preorder 与中序遍历  inorder。请构造二叉树并返回其根节点。
 *
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class ConstructBinaryTree {
    /**
     * 递归
     *
     * 时间复杂度：O(n)，其中 n 是树中的节点个数。
     *
     * 空间复杂度：O(n)，除去返回的答案需要的 O(n) 空间之外，
     * 我们还需要使用 O(n) 的空间存储哈希映射，以及 O(h)（其中 h 是树的高度）的空间表示递归时栈空间。这里 h < n，
     * 所以总空间复杂度为 O(n)。
     */
    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder){
        int len = preorder.length;
        //构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < len; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, len - 1, 0, len - 1);
    }

    private TreeNode myBuildTree(int[] preorder, int[] inorder, int preorderLeft, int preorderRight, int inorderLeft, int inorderRight) {
        if (preorderLeft > preorderRight){
            return null;
        }
        //前序遍历的第一个结点就是根节点
        int preorderRootIndx = preorderLeft;
        //在中序遍历中定位根节点
        int inorderRootIndx = indexMap.get(preorder[preorderRootIndx]);

        //先把根节点建立起来
        TreeNode root = new TreeNode(preorder[preorderRootIndx]);

        //得到左子树的数目
        int leftTreeSize = inorderRootIndx - inorderLeft;
        //递归遍历左子树
        root.left = myBuildTree(preorder, inorder, preorderLeft + 1, preorderLeft + leftTreeSize, inorderLeft, leftTreeSize - 1);

        //递归遍历右子树
        root.right = myBuildTree(preorder, inorder, preorderLeft + leftTreeSize + 1,  preorderRight, inorderRootIndx + 1, inorderRight);
        return root;
    }

    /**
     * 迭代
     *
     * 时间复杂度：O(n)，其中 n 是树中的节点个数。
     *
     * 空间复杂度：O(n)，除去返回的答案需要的 O(n) 空间之外，
     * 我们还需要使用 O(h)（其中 h 是树的高度）的空间存储栈。
     * 这里 h < n 所以（在最坏情况下）总空间复杂度为 O(n)。
     */
    public TreeNode buildTree2(int[] preorder, int[] inorder){
        if (preorder == null || preorder.length == 0){
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            //左节点
            if (node.val != inorder[inorderIndex]){
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                //找到右节点
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]){
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }
}
