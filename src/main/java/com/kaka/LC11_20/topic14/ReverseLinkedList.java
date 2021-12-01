package com.kaka.LC11_20.topic14;

import com.kaka.LC1_10.day02.ListNode;

/**
 * @Author : kaka
 * @Date: 2021-11-30 10:13
 *
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 * 链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
 */
public class ReverseLinkedList {
    /**
     * 1.迭代
     */
    public ListNode reverseList1(ListNode head) {
        ListNode prevNode = null;
        ListNode currNode = head;
        ListNode nextNode = head;
        while (currNode != null){
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }

        return prevNode;
    }

    /**
     * 2.递归
     */
    public ListNode reverseList(ListNode head){
        if (head == null || head.next == null){
            return head;
        }

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
