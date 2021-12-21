package com.kaka.LC31_40.topic35;

import com.kaka.LC1_10.day02.ListNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author : kaka
 * @Date: 2021-12-21 10:55
 *
 * @Description: 环形链表 II
 *
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 不允许修改 链表。
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
 */
public class LinkedListCycleII {
    /**
     * 哈希表
     *
     * 时间复杂度：O(N)，其中 N 为链表中节点的数目。我们恰好需要访问链表中的每一个节点。
     * 空间复杂度：O(N)，其中 N 为链表中节点的数目。我们需要将链表中的每个节点都保存在哈希表当中。
     */
    public ListNode detectCycle(ListNode head){
        ListNode pos = head;
        Set<ListNode> visited = new HashSet<>();
        while (pos != null){
            if (visited.contains(pos)){
                return pos;
            } else {
                visited.add(pos);
            }
            pos = pos.next;
        }
        return null;
    }

    /**
     * 快慢指针
     *
     * 时间复杂度：O(N)，其中 N 为链表中节点的数目。在最初判断快慢指针是否相遇时，slow 指针走过的距离不会超过链表的总长度；
     * 随后寻找入环点时，走过的距离也不会超过链表的总长度。因此，总的执行时间为 O(N)+O(N)=O(N)。
     * 空间复杂度：O(1)。我们只使用了 slow,fast,ptr 三个指针。
     *
     */
    public ListNode detectCycle2(ListNode head){
        if (head == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null){
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }

            if (fast == slow){
                ListNode ptr = head;
                while (ptr != slow){   //  a = c
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
