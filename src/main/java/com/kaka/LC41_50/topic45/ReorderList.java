package com.kaka.LC41_50.topic45;

import com.kaka.LC1_10.day02.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : kaka
 * @Date: 2021-12-31 19:29
 *
 * @Description: 重排链表
 *
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 链接：https://leetcode-cn.com/problems/reorder-list
 */
public class ReorderList {
    /**
     * 1.线性表
     *
     * 时间复杂度：O(N)，其中 N 是链表中的节点数。
     * 空间复杂度：O(N)，其中 N 是链表中的节点数。主要为线性表的开销。
     */
    public void reorderList(ListNode head){
        if (head == null){
            return;
        }

        List<ListNode> list = new ArrayList<>();
        ListNode h = head;
        while (h != null){
            list.add(h);
            h = h.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j){
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }

    /**
     * 2.找中点+逆序+合并链表
     */
    public void reorderList2(ListNode head){
        if (head == null){
            return;
        }
        ListNode l1 = head;
        ListNode mid = findMiddle(head);
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        mergeList(l1, l2);
    }

    private void mergeList(ListNode l1, ListNode l2) {
        ListNode l1Next;
        ListNode l2Next;
        while (l1 != null && l2 != null) {
            l1Next = l1.next;
            l2Next = l2.next;

            l1.next = l2;
            l2.next = l1Next;

            l1 = l1Next;
            l2 = l2Next;
        }
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
           ListNode nextNode = curr.next;
           curr.next = prev;
           prev = curr;
           curr = nextNode;
        }
        return prev;
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
