package com.kaka.day02;

/**
 * @Author : kaka
 * @Date: 2021-11-18 16:13
 *
 * 2个逆序的链表，要求从低位开始相加，得出结果也逆序输出，返回值是逆序结果链表的头结点。
 * 链接：https://leetcode-cn.com/problems/add-two-numbers/solution/liang-shu-xiang-jia-by-leetcode-solution/
 * 来源：力扣（LeetCode）
 */

public class AddTwoNumbers {
    //法一

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        //进位
        int carry = 0;

        while (l1 != null || l2 != null){
            //从输入链表中取数
            int n1 = (l1 != null ? l1.val: 0);
            int n2 = (l2 != null ? l2.val: 0);

            int sum = n1 + n2 + carry;
            carry = sum / 10; //进位

            //保存和
            if(head == null){
                head = tail = new ListNode(sum % 10);
            }else{
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }

            //移动到下一位
            if (l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        //最后检查carry中是否有进位
        if(carry > 0){
            tail.next = new ListNode(carry);
        }
        return head;
    }

    //法二：递归

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        return sum(l1,l2,0);
    }

    private ListNode sum(ListNode l1, ListNode l2, int add) {
        if (l1 == null && l2 == null && add == 0){ return null;}
        //求和
        int curVal = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + add;
        ListNode res = new ListNode(curVal % 10);

        //递归就和
        ListNode next = sum(l1 == null ? l1 : l1.next, l2 == null ? l2 : l2.next, curVal / 10);
        res.next = next;

        return res;
    }
}
