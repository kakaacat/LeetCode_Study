package com.kaka.LC1_100.LC91_100.topic98;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @Author : kaka
 * @Date: 2022-03-14 16:06
 *
 * @Description: 394. 字符串解码
 *
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 链接：https://leetcode-cn.com/problems/decode-string
 */
public class DecodeString {
    int ptr;
    public String decodeString(String s) {
        LinkedList<String> str = new LinkedList<String>();
        ptr = 0;

        while (ptr < s.length()) {
            char cur = s.charAt(ptr);
            if (Character.isDigit(cur)) {
                // 获取一个数字并进栈
                String digit = getDigits(s);
                str.addLast(digit);
            } else if (Character.isLetter(cur) || cur == '[') {
                // 获取一个字母并进栈
               str.addLast(String.valueOf(s.charAt(ptr++)));
            } else {
                ++ptr;
                LinkedList<String> sub = new LinkedList<String>();
                while (!"[".equals(str.peekLast())) {
                    sub.addLast(str.removeLast());
                }
                Collections.reverse(sub);
                // 左括号出栈
                str.removeLast();
                // 此时栈顶为当前 sub 对应的字符串应该出现的次数
                int repTime = Integer.parseInt(str.removeLast());
                StringBuffer t = new StringBuffer();
                String o = getString(sub);
                // 构造字符串
                while (repTime-- > 0) {
                    t.append(o);
                }
                // 将构造好的字符串入栈
                str.addLast(t.toString());

            }
        }

        return getString(str);
    }

    public String getDigits(String s) {
        StringBuffer ret = new StringBuffer();
        while (Character.isDigit(s.charAt(ptr))) {
            ret.append(s.charAt(ptr++));
        }
        return ret.toString();
    }

    public String getString(LinkedList<String> v) {
        StringBuffer ret = new StringBuffer();
        for (String s : v) {
            ret.append(s);
        }
        return ret.toString();
    }
}
