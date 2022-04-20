package com.kaka.LC.LC1_100.LC61_70.topic68;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author : kaka
 * @Date: 2022-02-07 17:37
 *
 * @Description: 155. 最小栈
 *
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *  
 * 链接：https://leetcode-cn.com/problems/min-stack
 */
public class MinStack {
    private Deque<Integer> stack;
    private Deque<Integer> minElem;

    public MinStack(){
        stack = new LinkedList<Integer>();
        minElem = new LinkedList<Integer>();
        minElem.push(Integer.MAX_VALUE);
    }

    public void push(int x){
        stack.push(x);
        minElem.push(Math.min(minElem.peek(), x));
    }

    public void pop(){
        stack.pop();
        minElem.pop();
    }

    public int top(){
        return stack.peek();
    }

    public int getMin(){
        return minElem.peek();
    }
}
