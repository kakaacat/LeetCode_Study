package com.kaka.LC.LC1_100.LC51_60.topic51;

import com.kaka.LC.LC1_100.LC1_10.day02.ListNode;

/**
 * @Author : kaka
 * @Date: 2022-01-06 16:38
 *
 * @Description: 82. 删除排序链表中的重复元素 II
 *
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，
 * 只保留原始链表中 没有重复出现 的数字。
 * 返回同样按升序排列的结果链表。
 *
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 */
public class RemoveDuplicatesFromSortedListII {
    /**
     * 1.一次遍历
     *
     * 时间复杂度：O(n)，其中 n 是链表的长度。
     * 空间复杂度：O(1)。
     */
    public ListNode deleteDuplicates(ListNode head){
        if (head == null){
            return head;
        }

        ListNode preHead = new ListNode(-101, head);
        ListNode prev = preHead;
        ListNode curr = head;

        while (curr != null && curr.next != null){
            if (curr.val == curr.next.val){
                int val = curr.val;
                while (curr != null && curr.val == val){
                    curr = curr.next;
                }
                prev.next = curr;
            } else {
               prev = curr;
               curr = curr.next;
            }
        }

        return preHead.next;
    }
}
