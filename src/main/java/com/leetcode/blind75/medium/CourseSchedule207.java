package com.leetcode.blind75.medium;

import java.util.ArrayList;
import java.util.List;

/*
207. Course Schedule
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.



Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So it is possible.
 */
public class CourseSchedule207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<>());

        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);  // edge: b → a
        }

        int[] state = new int[numCourses]; // 0=unvisited, 1=visiting, 2=visited

        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0 && hasCycleDFS(i, graph, state)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasCycleDFS(int course, List<List<Integer>> graph, int[] state) {
        state[course] = 1; // visiting

        for (int next : graph.get(course)) {
            if (state[next] == 1) return true;       // cycle found
            if (state[next] == 0 && hasCycleDFS(next, graph, state))
                return true;  // DFS deeper
        }

        state[course] = 2; // visited
        return false;
    }

    public static void main(String[] args) {
        CourseSchedule207 solver = new CourseSchedule207();
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        System.out.println(solver.canFinish(numCourses, prerequisites)); // true

        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        System.out.println(solver.canFinish(numCourses, prerequisites2)); // false
    }
}
