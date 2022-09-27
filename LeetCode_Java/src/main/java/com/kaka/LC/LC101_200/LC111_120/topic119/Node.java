package com.kaka.LC.LC101_200.LC111_120.topic119;

/**
 * @Author : kaka
 * @Date: 2022-04-05 19:45
 */
public class Node {
    public int key, val, freq;
    Node prev, next;

    public Node() {
        this(-1, -1, 0);
    }

    public Node(int key, int val, int freq) {
        this.key = key;
        this.val = val;
        this.freq = freq;
    }
}
