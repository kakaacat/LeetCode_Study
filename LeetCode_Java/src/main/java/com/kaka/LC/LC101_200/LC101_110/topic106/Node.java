package com.kaka.LC.LC101_200.LC101_110.topic106;

/**
 * @Author : kaka
 * @Date: 2022-03-23 09:47
 */
public class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
