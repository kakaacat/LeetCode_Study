package com.kaka.LC31_40.topic36;

import com.kaka.LC1_10.day02.ListNode;

import javax.crypto.interfaces.PBEKey;

/**
 * @Author : kaka
 * @Date: 2021-12-22 10:43
 *
 * @Description: 合并K个升序链表
 *
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 *输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 *
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 */
public class MergeKSortedLists {
    /**
     * 1、顺序合并
     *
     * 时间复杂度: O(k^2 n)
     * 空间复杂度：没有用到与 k 和 n 规模相关的辅助空间，故渐进空间复杂度为 O(1)。
     */
    public ListNode mergeKLists(ListNode[] lists){
        ListNode ans = null;
        for (int i = 0; i < lists.length; i++) {
            ans = mergeTwoLists(ans, lists[i]);
        }
        return ans;
    }

    private ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a == null ? b : a;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        ListNode aPtr = a;
        ListNode bPtr = b;

        while (aPtr != null && bPtr != null) {
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr == null ? bPtr : aPtr);

        return head.next;
    }

    /**
     * 优化方法一: 分治合并
     *
     * 时间复杂度为 O(kn×logk)。
     * 空间复杂度：递归会使用到 O(logk) 空间代价的栈空间。
     */
    public ListNode mergeKLists2(ListNode[] lists){
       return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }

        int mid = (l + r) / 2;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }
}
