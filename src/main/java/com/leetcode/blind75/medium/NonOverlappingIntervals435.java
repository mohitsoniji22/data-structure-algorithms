package com.leetcode.blind75.medium;

import java.util.Arrays;

public class NonOverlappingIntervals435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int nonOverlappingCount = 1;
        int lastEnd = intervals[0][1];

         for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= lastEnd) {
                nonOverlappingCount++;
                lastEnd = intervals[i][1];
            }
        }

        return intervals.length - nonOverlappingCount;
    }

    public static void main(String[] args) {
        NonOverlappingIntervals435 sol = new NonOverlappingIntervals435();

        int[][] intervals = {
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 3}
        };

        int result = sol.eraseOverlapIntervals(intervals);

        System.out.println("Minimum number of intervals to remove = " + result);
    }
}
