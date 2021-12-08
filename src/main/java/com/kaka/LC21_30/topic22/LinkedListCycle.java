package com.kaka.LC21_30.topic22;

import com.kaka.LC1_10.day02.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author : kaka
 * @Date: 2021-12-07 21:21
 *
 * @Description: 环形链表
 *
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为
 * 了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 */
public class LinkedListCycle {
    /**
     * 1、哈希表
     *
     * 时间复杂度：O(N)，其中 N 是链表中的节点数。最坏情况下我们需要遍历每个节点一次。
     * 空间复杂度：O(N)，其中 N 是链表中的节点数。主要为哈希表的开销，最坏情况下我们需要将每个节点插入到哈希表中一次。
     */
    public boolean hasCycle1(ListNode head) {
        Set<ListNode> hashSet = new HashSet<ListNode>();
        while(head != null){
            if(!hashSet.add(head)){
                return true;
            }
            head = head.next;
        }
        return false;
    }
    /**
     * 2、快慢指针
     *
     * 时间复杂度：O(N)，其中 N 是链表中的节点数。
     *      当链表中不存在环时，快指针将先于慢指针到达链表尾部，链表中每个节点至多被访问两次。
     *      当链表中存在环时，每一轮移动后，快慢指针的距离将减小一。而初始距离为环的长度，因此至多移动 N 轮。
     * 空间复杂度：O(1)。我们只使用了两个指针的额外空间。
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (slow != fast){
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }
}
