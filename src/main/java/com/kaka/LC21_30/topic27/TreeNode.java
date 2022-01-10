package com.kaka.LC21_30.topic27;

/**
 * @Author : kaka
 * @Date: 2021-12-13 10:16
 * @Description: 类
 */
public class TreeNode {
    public int val;
    public com.kaka.LC21_30.topic27.TreeNode left;
    public com.kaka.LC21_30.topic27.TreeNode right;

    public TreeNode(){}
    public TreeNode(int val){
        this.val = val;
    }
    public TreeNode(int val, com.kaka.LC21_30.topic27.TreeNode left, com.kaka.LC21_30.topic27.TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
