package com.kaka.LC.LC1_100.LC21_30.topic21;

import com.kaka.LC.LC1_100.LC1_10.day02.ListNode;

/**
 * @Author : kaka
 * @Date: 2021-12-07 10:22
 *
 * @Description: 合并两个有序链表
 *
 * 将两个升序链表合并为一个新的 升序 链表并返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 *
 * 提示：
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 *
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedLists {
    /**
     * 1、递归
     *
     * 时间复杂度：O(n + m)
     * 空间复杂度：O(n + m)
     */
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }else if(list2 == null){
            return list1;
        }else if(list1.val <= list2.val){
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }else{
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
    /**
     * 2、迭代
     * 
     * 时间复杂度：O(n + m)
     * 空间复杂度：O(1)
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                curr.next = list1;
                list1 = list1.next;
            }else{
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        curr.next = list1 == null ? list2 : list1;

        return dummyHead.next;
    }
}
