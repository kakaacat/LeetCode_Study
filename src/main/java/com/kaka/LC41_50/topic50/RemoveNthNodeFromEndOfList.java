package com.kaka.LC41_50.topic50;

import com.kaka.LC1_10.day02.ListNode;

import java.util.*;

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

    /**
     * 2.双指针
     *
     * 时间复杂度：O(L)，其中 L 是链表的长度。
     * 空间复杂度：O(1)。
     */
    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode ans = new ListNode(-1, head);
        ListNode fast = head;
        ListNode slow = ans;

        //快指针永远要不慢指针快 n 个结点
        //当快指针到链表尾的时候，慢指针真好指向倒数第 n 个结点的前驱
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return ans.next;
    }

    /**
     * 补充栈的写法
     *
     */
    public ListNode removeNth(ListNode head, int n){
        ListNode ans = new ListNode(-1, head);
        Deque<ListNode> stack = new LinkedList<ListNode>();

        ListNode h = ans;
        while (h != null){
            stack.push(h);
            h = h.next;
        }
        //出栈也是要花费时间的，不如数组可以直接找到
        for (int i = 0; i < n; i++) {
            stack.pop();
        }

        ListNode prev = stack.pop();
        prev.next = prev.next.next;

        return ans.next;
    }
}
