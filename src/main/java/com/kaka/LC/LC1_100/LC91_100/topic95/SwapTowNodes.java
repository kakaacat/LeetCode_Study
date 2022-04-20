package com.kaka.LC.LC1_100.LC91_100.topic95;

import com.kaka.LC.LC1_100.LC1_10.day02.ListNode;

/**
 * @Author : kaka
 * @Date: 2022-03-11 14:44
 *
 * @Description: 24. 两两交换链表中的节点
 *
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 *
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */
public class SwapTowNodes {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = node1.next;

            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;

            temp = node1;
        }
        return dummyHead.next;
    }
}
