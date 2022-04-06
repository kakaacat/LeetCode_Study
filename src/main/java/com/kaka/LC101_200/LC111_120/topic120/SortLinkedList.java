package com.kaka.LC101_200.LC111_120.topic120;

import com.kaka.LC1_100.LC1_10.day02.ListNode;

/**
 * @Author : kaka
 * @Date: 2022-04-06 09:55
 *
 * @Description: 排序奇升偶降链表
 *
 * 给定一个奇数位升序，偶数位降序的链表，将其重新排序。
 *
 * 输入: 1->8->3->6->5->4->7->2->NULL
 * 输出: 1->2->3->4->5->6->7->8->NULL
 */
public class SortLinkedList {
    public ListNode sortLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //先把奇数位链表和偶数位链表拆开
        ListNode oddCur = head;
        ListNode evenCur = head.next;
        ListNode oddHead = head;
        ListNode evenHead = head.next;
        while (evenCur != null) {
            oddCur.next = evenCur.next;
            if (oddCur.next != null) {
                evenCur.next = oddCur.next.next;
            }
            oddCur = oddCur.next;
            evenCur = evenCur.next;
        }
        //然后把偶数位链表逆序
        evenHead = reverseList(evenHead);
        //最后合并两个链表
        return mergeList(oddHead, evenHead);
    }

    private ListNode mergeList(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode();
        ListNode curr = dummyHead;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                curr.next = head1;
                head1 = head1.next;
            } else {
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
        }

        curr.next = head1 != null ? head1 : head2;

        return dummyHead.next;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode n = curr.next;
            curr.next = prev;
            prev = curr;
            curr = n;
        }
        return prev;
    }
}
