package com.kaka.LC71_80.topic79;

import com.kaka.LC1_10.day02.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : kaka
 * @Date: 2022-02-23 12:49
 *
 * @Description: 234. 回文链表
 *
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 *
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 */
public class PalindromeLinkedList {
    /**
     * 转成数组操作
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public boolean isPalindrome(ListNode head) {
        List<Integer> vals = new ArrayList<>();

        // 将链表的值复制到数组中
        ListNode cur = head;
        while (cur != null) {
            vals.add(cur.val);
            cur = cur.next;
        }

        // 使用双指针判断是否回文
        int front = 0, back = vals.size() - 1;
        while (front < back) {
            if (!vals.get(front).equals(vals.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }
}
