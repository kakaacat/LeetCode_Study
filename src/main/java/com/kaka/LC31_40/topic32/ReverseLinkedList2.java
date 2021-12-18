package com.kaka.LC31_40.topic32;

import com.kaka.LC1_10.day02.ListNode;

/**
 * @Author : kaka
 * @Date: 2021-12-17 20:29
 *
 * @Description: 反转链表 II
 *
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *  
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 */
public class ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int left, int right){
        if (head == null || left == right){
            return head;
        }
        //虚拟头结点
        ListNode preHead = new ListNode(-1);
        preHead.next = head;

        ListNode pre = preHead;

        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        //左节点
        ListNode leftNode = pre.next;

        //右节点
        ListNode rightNode = pre;
        for (int i = 0; i <= right - left; i++) {
            rightNode = rightNode.next;
        }
        ListNode tail = rightNode.next;

        ListNode nextNode = leftNode.next;
        pre.next = rightNode;
        leftNode.next = tail;
        while(nextNode != tail){
            rightNode = leftNode;
            leftNode = nextNode;
            nextNode = nextNode.next;

            leftNode.next = rightNode;
        }

        return preHead.next;
    }
    
    private void reverseList(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }
}
