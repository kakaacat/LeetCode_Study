package com.kaka.LC.LC1_100.LC1_10.topic08;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author : kaka
 * @Date: 2021-11-24 09:51
 *
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 *
 * 函数 myAtoi(string s) 的算法如下：
 *
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
 * 返回整数作为最终结果。
 *
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 */
public class StringToInteger {
    /**
     * 1.自动机实现
     * 时间复杂度：O(n)，其中 n 为字符串的长度。我们只需要依次处理所有的字符，处理每个字符需要的时间为 O(1)。
     *
     * 空间复杂度：O(1)。自动机的状态只需要常数空间存储。
     */
    public int myAtoi1(String str){
        Automaton automaton = new Automaton();
        int len = str.length();
        for (int i = 0; i < len; i++) {
            automaton.get(str.charAt(i));
        }

        return (int)(automaton.sign * automaton.ans);
    }

    /**
     * 2.正则表达式
     *
     * 教程： https://www.runoob.com/java/java-regular-expressions.html
     *
     * ^[\\+\\-]?\\d+
     *
     * ^ 表示匹配字符串开头，我们匹配的就是 '+'  '-'  号
     *
     * [] 表示匹配包含的任一字符，比如[0-9]就是匹配数字字符 0 - 9 中的一个
     *
     * ? 表示前面一个字符出现零次或者一次，这里用 ? 是因为 '+' 号可以省略
     *
     *  \\d 表示一个数字 0 - 9 范围
     *
     * + 表示前面一个字符出现一次或者多次，\\d+ 合一起就能匹配一连串数字了
     */
    public int myAtoi(String str) {
        //清空字符串开头和末尾空格（这是trim方法功能，事实上我们只需清空开头空格）
        str = str.trim();

        //Java正则表达式
        Pattern pattern = Pattern.compile("^[\\+\\-]?\\d+");
        Matcher matcher = pattern.matcher(str);
        int value = 0;
        if (matcher.find()){
            //字符串转整数，溢出
            try {
                value = Integer.parseInt(str.substring(matcher.start(), matcher.end()));
            } catch (Exception e){
                //由于有的字符串"42"没有正号，所以我们判断'-'
                value = str.charAt(0) == '-' ? Integer.MIN_VALUE: Integer.MAX_VALUE;
            }
        }

        return value;
    }

}

class Automaton {
    public int sign = 1;
    public long ans = 0;
    private String state = "start";
    public Map<String, String[]> table = new HashMap<String, String[]>(){{
        put("start",      new String[]{"start", "signed", "in_number", "end"});
        put("signed",     new String[]{"end",    "end",   "in_number", "end"});
        put("in_number",  new String[]{"end",    "end",   "in_number", "end"});
        put("end",        new String[]{"end",    "end",    "end",      "end"});
    }};

    private int get_col(char c){
        if(c == ' '){
            return 0;
        }
        if (c == '-' || c == '+'){
            return 1;
        }
        if (Character.isDigit(c)){
            return 2;
        }
        return 3;
    }

    public void get(char c){
        state = table.get(state)[get_col(c)];
        if ("in_number".equals(state)){
            ans = ans * 10 + c - '0';
            ans = sign == 1 ? Math.min(ans, (long)Integer.MAX_VALUE) : Math.min(ans, -(long)Integer.MIN_VALUE);
        } else if ("signed".equals(state)){
            sign = c == '+' ? 1 : -1;
        }
    }
}