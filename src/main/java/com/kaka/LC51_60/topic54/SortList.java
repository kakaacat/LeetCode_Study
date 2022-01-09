package com.kaka.LC51_60.topic54;

import com.kaka.LC1_10.day02.ListNode;

/**
 * @Author : kaka
 * @Date: 2022-01-09 14:14
 *
 * @Description: 148. 排序链表
 *
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 * https://leetcode-cn.com/problems/sort-list/
 */
public class SortList {
    /**
     * 自顶向下归并排序
     *
     * 时间复杂度：O(nlogn)，其中 n 是链表的长度。
     * 空间复杂度：O(logn)，其中 n 是链表的长度。空间复杂度主要取决于递归调用的栈空间。
     */
    public ListNode sortList(ListNode head){
        return sortList(head, null);
    }

    private ListNode sortList(ListNode head, ListNode tail) {
        if (head == null){
            return head;
        }
        if (head.next == tail){
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail){
            slow = slow.next;
            fast = fast.next;
            if (fast != tail){
                fast = fast.next;
            }
        }

        ListNode mid = slow;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        ListNode sorted = merge(list1, list2);
        return sorted;
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode prev = new ListNode(0);
        ListNode curr = prev, l1 = head1, l2 = head2;
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if (l1 != null){
            curr.next = l1;
        }
        if (l2 != null){
            curr.next = l2;
        }

        return prev.next;
    }
}
