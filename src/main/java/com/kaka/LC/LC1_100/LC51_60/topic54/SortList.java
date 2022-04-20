package com.kaka.LC.LC1_100.LC51_60.topic54;

import com.kaka.LC.LC1_100.LC1_10.day02.ListNode;

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

    /**
     * 自底向上归并排序
     *
     * 时间复杂度：O(nlogn)，其中 n 是链表的长度。
     * 空间复杂度：O(1)。
     */
    public ListNode sortList2(ListNode head){
        if (head == null){
            return head;
        }

        int len = 0;
        ListNode h = head;
        while (h != null){
            len++;
            h = h.next;
        }

        ListNode dummyHead = new ListNode(0, head);
        for (int subLength = 1; subLength < len; subLength <<= 1) {
            ListNode prev = dummyHead, curr = dummyHead.next;
            while (curr != null){
                //子链表尾
                ListNode head1 = curr;
                for (int i = 1; i < subLength && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode head2 = curr.next;
                curr.next = null;
                curr = head2;
                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }
                ListNode merged = merge(head1, head2);
                prev.next = merged;
                while (prev.next != null) {
                    prev = prev.next;
                }
                curr = next;
            }
        }
        return dummyHead.next;
    }
}
