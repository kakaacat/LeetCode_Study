package com.kaka.LC1_100.LC11_20.topic12;


/**
 * @Author : kaka
 * @Date: 2021-11-28 14:42
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。
 * 数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
 * 同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给你一个整数，将其转为罗马数字。
 *
 ** 1 <= num <= 3999
 *
 * 链接：https://leetcode-cn.com/problems/integer-to-roman
 */
public class IntegerToRoman {
    /**
     * 1.贪心算法
     * 根据罗马数字的唯一表示法，为了表示一个给定的整数 num，我们寻找不超过 num 的最大符号值，
     * 将 num 减去该符号值，然后继续寻找不超过 num 的最大符号值，将该符号拼接在上一个找到的符号之后，
     * 循环直至 num 为 0。最后得到的字符串即为 num 的罗马数字表示。
     *
     * 时间复杂度：O(1)。由于 valueSymbols 长度是固定的，且这 13字符中的每个字符的出现次数均不会超过 3，
     * 因此循环次数有一个确定的上限。对于本题给出的数据范围，循环次数不会超过 15 次。
     *
     * 空间复杂度：O(1)。
     */
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] romanStrs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman1(int num) {
        StringBuffer roman = new StringBuffer();
        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            String romanStr = romanStrs[i];
            while(num >= value){
                num -= value;
                roman.append(romanStr);
            }
            if (num == 0){
                break;
            }
        }

        return roman.toString();
    }

    /**
     * 2.硬编码数字
     *
     * 千位数字只能由 M 表示；
     * 百位数字只能由 C，CD，D 和 CM 表示；
     * 十位数字只能由 X，XL，L 和 XC 表示；
     * 个位数字只能由 I，IV，V 和 IX 表示。
     * 这恰好把这 13个符号分为四组，且组与组之间没有公共的符号。
     * 因此，整数 num 的十进制表示中的每一个数字都是可以单独处理的。
     * 进一步地，我们可以计算出每个数字在每个位上的表示形式，整理成一张硬编码表。
     * 如下图所示，其中 0对应的是空字符串。
     * **也就是把所有的可能组合列成一张表
     *
     * 时间复杂度：O(1)。计算量与输入数字的大小无关。
     * 空间复杂度：O(1)。
     */
    public String intToRoman(int num){
        String[] thousands = {"", "M", "MM", "MMM"};    //1千、2千、3千
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};   //1百、2百、3百、四百、五百、六百、七百、八百、九百
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        StringBuffer roman = new StringBuffer();
        roman.append(thousands[num / 1000]);
        roman.append(hundreds[num / 100 % 10]);
        roman.append(tens[num / 10 % 10]);
        roman.append(ones[num % 10]);

        return roman.toString();
    }

}
