package com.kaka.LC1_100.LC11_20.topic17;

import com.kaka.LC1_100.LC1_10.day02.ListNode;

/**
 * @Author : kaka
 * @Date: 2021-12-03 09:42
 *
 * <<25. K 个一组翻转链表>>
 *
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * *进阶：
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;   //保存链表头
        ListNode pre = hair;    //用于指出子链表的头的前一个节点
        ListNode tail = hair;   //用于指出子链表的尾
        ListNode next;          //用于记录子链表尾的下一个节点
        ListNode[] reserve;     //用于反转子链表

        while (head != null){
            //移动tail，找出需要反转的子链表
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null){  //最后节点个数不满足K
                    return hair.next;
                }
            }
            next = tail.next;   //记录子链表尾的下一个节点
            //反转子链表
            reserve = myReverse(head, tail);
            head = reserve[0];
            tail = reserve[1];
            //把反转后的子链表链接回原来的链表
            pre.next = head;
            tail.next = next;
            //调整标志指针
            pre = tail;     //下一个子链表头的前一个节点
            head = tail.next;   //下一个子链表的头
        }

        return hair.next;
    }

    /**
     * 反转子链表
     * @param head  //反转前子链表的头
     * @param tail  //反转前子链表的尾
     * @return new ListNode[]{tail, head}   //反转后子链表的头尾
     */
    private ListNode[] myReverse(ListNode head, ListNode tail){
        ListNode prev = tail.next;
        ListNode p = head;
        ListNode next;
        while (prev != tail){
            next = p.next;
            p.next = prev;
            prev = p;
            p = next;
        }

        return new ListNode[]{tail, head};
    }
}
