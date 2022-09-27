package com.kaka.LC.LC1_100.LC31_40.topic36;

import com.kaka.LC.LC1_100.LC1_10.day02.ListNode;


/**
 * @Author : kaka
 * @Date: 2021-12-22 11:10
 *
 * @Description: 优先队列中的状态类
 */
public class Status implements Comparable<Status>{
    int var;
    ListNode node;

    public Status(int var, ListNode node) {
        this.var = var;
        this.node = node;
    }

    @Override
    public int compareTo(Status status2) {
        return this.var - status2.var;
    }
}
