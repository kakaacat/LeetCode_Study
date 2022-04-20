package com.kaka.LC.LC1_100.LC21_30.topic28;

import java.util.*;

/**
 * @Author : kaka
 * @Date: 2021-12-13 21:53
 *
 * @Description: 有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *  
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 */
public class ValidParentheses {
    /**
     * 栈
     *
     * 时间复杂度：O(n)，其中 n 是字符串 s 的长度。
     *
     * 空间复杂度：O(n+∣Σ∣)，其中 Σ 表示字符集，本题中字符串只包含 6 种括号，∣Σ∣=6。
     * 栈中的字符数量为 O(n)，而哈希表使用的空间为 O(∣Σ∣)，相加即可得到总空间复杂度。
     */
    public boolean isValid(String s){
        int len = s.length();
        //个数不是偶数直接就返回false
        if (len % 2 == 1){
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};

        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            //如果遇到右括号，就去栈顶找对应的左括号
            if (pairs.containsKey(c)){
                //没有找到返回false
                if (stack.isEmpty() || stack.peek() != pairs.get(c)){
                    return false;
                }
                //找到匹配
                stack.pop();
            }else{
                //是左括号就入栈
                stack.push(c);
            }
        }
        
        return stack.isEmpty();
    }
}
