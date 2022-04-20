package com.kaka.LC.LC1_100.LC21_30.topic27;

/**
 * @Author : kaka
 * @Date: 2021-12-13 10:16
 * @Description: 类
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(){}
    public TreeNode(int val){
        this.val = val;
    }
    public TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
