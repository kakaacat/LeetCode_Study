package com.kaka.LC41_50.topic46;

import com.kaka.LC1_10.day02.ListNode;

/**
 * @Author : kaka
 * @Date: 2022-01-01 14:53
 *
 * @Description: 链表中第K个节点
 *
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 *
 * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 */
public class GetKthFromEnd {
    /**
     * 1.顺序查找
     *
     * 时间复杂度：O(n)，其中 n 为链表的长度。需要两次遍历。
     * 空间复杂度：O(1)。
     */
    public ListNode getKthFromEnd(ListNode head, int k){
        int n = 0;
        ListNode res = head;
        for (ListNode node = head; node != null; node = node.next){
            n++;
        }
        for (int i = 0; i < n - k; i++) {
            res = res.next;
        }

        return res;
    }

    /**
     * 2. 快慢指针
     *
     * 时间复杂度：O(n)，其中 n 为链表的长度。我们使用快慢指针，只需要一次遍历即可，复杂度为 O(n)。
     * 空间复杂度：O(1)。
     */
    public ListNode getKthFromEnd2(ListNode head, int k){
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && k > 0){
            fast = fast.next;
            k--;
        }
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
