package com.kaka.LC81_90.topic83;

import java.util.*;

/**
 * @Author : kaka
 * @Date: 2022-02-27 15:34
 *
 * @Description: 39. 组合总和
 *
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，
 * 找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 *
 * 链接：https://leetcode-cn.com/problems/combination-sum
 */
public class CombinationSum {
    /**
     * 回溯 ＋ 剪枝
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> ans = new ArrayList<>();
        if (len == 0) {
            return ans;
        }

        // 排序是剪枝的前提
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, len, target, path, ans);
        return ans;
    }

    private void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> ans) {
        // 由于进入更深层的时候，小于 0 的部分被剪枝，因此递归终止条件值只判断等于 0 的情况
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin ; i < len; i++) {
            // 重点理解这里剪枝，前提是候选数组已经有序，
            if (target - candidates[i] < 0) {
                break;
            }

            path.addLast(candidates[i]);
            dfs(candidates, i, len, target - candidates[i], path, ans);
            path.removeLast();
        }
    }
}
