package com.kaka.LC1_100.LC41_50.topic47;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Author : kaka
 * @Date: 2022-01-02 16:29
 *
 * @Description: 合并区间
 *
 * 给定一个列表，将有重叠部分的合并。例如[ [ 1 3 ] [ 2 6 ] ] 合并成 [ 1 6 ] 。
 *
 * https://leetcode-cn.com/problems/merge-intervals
 */
public class MergeInterval {
    public List<Interval> mergeInterval(List<Interval> intervals){
        //按区间的起始值大小排序
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        int len = intervals.size();
        if (len <= 1){
            return intervals;
        }

        List<Interval> res = new ArrayList<Interval>();
        Interval prev = intervals.get(0);
        for (int i = 1; i < len; i++) {
            Interval curr = intervals.get(i);
            if (prev.end >= curr.start){
                prev.end = Math.max(prev.end, curr.end);
            } else {
                res.add(prev);
                prev = curr;
            }
        }
        res.add(prev);

        return res;
    }
}
