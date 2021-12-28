package com.kaka.LC41_50.topic42;

import java.util.Stack;

/**
 * @Author : kaka
 * @Date: 2021-12-28 16:00
 *
 * @Description: 使用栈实现队列
 */
public class MyQueue {
    private int front;
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public MyQueue(){
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }
    //入队
    public void push(int x){
        if (s1.empty()){
            front = x;
        }
        while (!s1.empty()){
            s2.push(s1.pop());
        }
        s1.push(x);
        while (!s2.empty()){
            s1.push(s2.pop());
        }
    }
    public void push2(int x){
        if (s1.empty()){
            front = x;
        }
        s1.push(x);
    }
    //出队
    public int pop(){
        int temp = s1.pop();
        if (!s1.empty()){
            front = s1.peek();
        }
        return temp;
    }
    public int pop2(){
        while (!s1.empty()){
            s2.push(s1.pop());
        }
        int temp = s2.pop();
        while (!s2.empty()){
            s1.push(s2.pop());
        }
        if (!s1.empty()){
            front = s1.peek();
        }
        return temp;
    }
    //队首
    public int peek(){
        return front;
    }
    //是否为空
    public boolean empty(){
        return s1.empty();
    }
}
