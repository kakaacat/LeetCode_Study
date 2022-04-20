package com.kaka.LC.LC101_200.LC121_130.topic126;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author : kaka
 * @Date: 2022-04-13 20:13
 *
 * @Description: 207. 课程表
 *
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，
 * 其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 *
 * 链接：https://leetcode-cn.com/problems/course-schedule
 */
public class CourseSchedule {
    List<List<Integer>> edges;
    int[] visited;
    boolean valid = true;

    /**
     * dfs
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<Integer>());
        }

        visited = new int[numCourses];

        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }

        for (int i = 0; i < numCourses && valid; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return valid;
    }

    private void dfs(int n) {
        visited[n] = 1;
        for (int v : edges.get(n)) {
            if (visited[v] == 0) {
                dfs(v);
                if (!valid) {
                    return;
                }
            } else if (visited[v] == 1) {
                valid = false;
                return;
            }
        }
        visited[n] = 2;
    }

    /**
     * bfs
     */
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<Integer>());
        }

        visited = new int[numCourses];

        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            ++visited[info[0]];
        }

        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            //入度为0
            if (visited[i] == 0) {
                queue.offer(i);
            }
        }

        int visitedSize = 0;
        while (!queue.isEmpty()) {
            ++visitedSize;
            int v = queue.poll();
            for (int n : edges.get(v)) {
                --visited[n];
                if (visited[n] == 0) {
                    queue.offer(n);
                }
            }
        }

        return visitedSize == numCourses;
    }
}
