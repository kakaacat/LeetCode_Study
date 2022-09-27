package com.kaka.LC.LC101_200.LC101_110.topic109;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author : kaka
 * @Date: 2022-03-26 10:21
 *
 * @Description: 剑指 Offer 09. 用两个栈实现队列
 *
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 */
public class CQueue {
    private Deque<Integer> inStack;
    private Deque<Integer> outStack;

    public CQueue(){
        inStack = new ArrayDeque<>();
        outStack = new ArrayDeque<>();
    }

    public void appendTail(int value) {
        inStack.push(value);
    }

    public int deleteHead() {
        if (outStack.isEmpty()) {
            if (inStack.isEmpty()) {
                return -1;
            } else {
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
            }
        }
        return outStack.pop();
    }
}
