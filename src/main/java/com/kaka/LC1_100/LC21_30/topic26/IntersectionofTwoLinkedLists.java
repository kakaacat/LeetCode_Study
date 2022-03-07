package com.kaka.LC1_100.LC21_30.topic26;

import com.kaka.LC1_100.LC1_10.day02.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author : kaka
 * @Date: 2021-12-11 09:49
 *
 * @Description: 相交链表（Intersection of Two Linked Lists）
 *
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 *
 * ->示例：
 *      输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 *      输出：Intersected at '8'
 *      解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
 *      从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,6,1,8,4,5]。
 *      在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
 */
public class IntersectionofTwoLinkedLists {
    /**
     * 1.哈希集合 HashSet
     *
     * 时间复杂度：O(m+n)，其中 m 和 n 是分别是链表 headA 和 headB 的长度。需要遍历两个链表各一次。
     *
     * 空间复杂度：O(m)，其中 m 是链表 headA 的长度。需要使用哈希集合存储链表 headA 中的全部节点。
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB){
        Set<ListNode> listNodes = new HashSet<>();
        ListNode temp = headA;

        while(temp != null){
            listNodes.add(temp);
            temp = temp.next;
        }

        temp = headB;

        while(temp != null){
            if(listNodes.contains(temp)){
               return temp;
            }
            temp = temp.next;
        }
        return null;
    }
    /**
     * 2.双指针
     *
     * 时间复杂度：O(m+n)，其中 m 和 n 是分别是链表 headA 和 headB 的长度。
     * 两个指针同时遍历两个链表，每个指针遍历两个链表各一次。
     *
     * 空间复杂度：O(1)
     *
     * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/solution/xiang-jiao-lian-biao-by-leetcode-solutio-a8jn/
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        if (headA == null || headB == null){
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB){
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
