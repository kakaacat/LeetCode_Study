package com.kaka.LC1_100.LC61_70.topic62;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author : kaka
 * @Date: 2022-01-28 19:28
 *
 * @Description: 93. 复原 IP 地址
 *
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，
 * x这些地址可以通过在 s 中插入 '.' 来形成。你不能重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 *
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 */
public class RestoreIPAddresses {
    /**
     * 回溯剪枝
     * @param s
     * @return
     */
    public List<String> restoreIPAddresses(String s){
        int len = s.length();
        List<String> res = new ArrayList<>();
        if (len > 12 || len < 4){
            return res;
        }
        Deque<String> path = new ArrayDeque<>(4);
        dfs(s, len, 0, 4, path, res);
        return res;
    }

    private void dfs(String s, int len, int begin, int residue, Deque<String> path, List<String> res) {
        if (begin == len && residue == 0){
            res.add(String.join(".", path));
            return;
        }

        for (int i = begin; i < begin + 3; i++) {
            if (i >= len){
                break;
            }
            //如果剩余元素大于ip最多能容纳的个数，就剪枝。
            if (residue * 3 < len - 1){
                continue;
            }

            if (judgeIPSegment(s, begin, i)){
                String curIPsegment = s.substring(begin, i + 1);
                path.addLast(curIPsegment);

                dfs(s, len, i + 1, residue - 1, path, res);
                //回溯
                path.removeLast();
            }
        }
    }

    private boolean judgeIPSegment(String s, int left, int right) {
        int len = right - left + 1;
        if (len > 1 && s.charAt(left) == '0'){
            return false;
        }
        int res = 0;
        while (left <= right){
            res = res * 10 + s.charAt(left) - '0';
            left++;
        }
        return res >= 0 && res <= 255;
    }
}
