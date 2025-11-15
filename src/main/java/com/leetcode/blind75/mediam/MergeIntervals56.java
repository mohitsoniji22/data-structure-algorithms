package com.leetcode.blind75.mediam;

import java.util.*;

/*
    * Merge Intervals
    * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
    * Example 1:
    * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
    * Output: [[1,6],[8,10],[15,18]]
    * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
    * Example 2:
    * Input: intervals = [[1,4],[4,5]]
    * Output: [[1,5]]
    * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
public class MergeIntervals56 {

    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        // Step 1: Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        // Step 2: Create result list
        List<int[]> merged = new ArrayList<>();
        // Step 3: Iterate through intervals
        int[] current = intervals[0];
        merged.add(current);

        for (int[] interval : intervals) {
            if (interval[0] <= current[1]) {
                // Overlapping intervals → merge
                current[1] = Math.max(current[1], interval[1]);
            } else {
                // Non-overlapping → add to list
                current = interval;
                merged.add(current);
            }
        }

        // Step 4: Convert list to array
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] result = merge(intervals);

        System.out.print("Merged Intervals: ");
        for (int[] interval : result) {
            System.out.print(Arrays.toString(interval) + " ");
        }
        // Additional test case
        int[][] intervals1 = {{1,3},{2,6},{8,22},{15,18}};
        int[][] result1 = merge(intervals1);

        System.out.print("Merged Intervals 2: ");
        for (int[] interval : result1) {
            System.out.print(Arrays.toString(interval) + " ");
        }
    }
}

