package com.kaka.LC41_50.topic50;

import com.kaka.LC1_10.day02.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : kaka
 * @Date: 2022-01-05 16:00
 *
 * @Description: 19. 删除链表的倒数第 N 个结点
 *
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthNodeFromEndOfList {
    /**
     * 1.数组 / 栈
     *
     * 时间复杂度 O(n),n为列表长度
     * 空间复杂度 O(n)
     */
    public ListNode removeNthNode(ListNode head, int n){
        ListNode ans = new ListNode(-1, head);
        List<ListNode> nodes = new ArrayList<>();
        ListNode h = ans;
        while (h != null){
            nodes.add(h);
            h = h.next;
        }

        ListNode prev = nodes.get(nodes.size() - n - 1);
        prev.next = prev.next.next;

        return ans.next;
    }
}
