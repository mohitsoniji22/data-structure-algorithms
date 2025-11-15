package com.leetcode.blind75.easy;

import java.util.Arrays;

public class MeetingRooms252 {

    public static boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length == 0) return true;

        // Step 1: Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 2: Check for overlap
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false; // Overlap found
            }
        }

        return true; // No overlaps
    }

    public static void main(String[] args) {
        int[][] intervals1 = {{0,30}, {5,10}, {15,20}};
        int[][] intervals2 = {{7,10}, {2,4}};

        System.out.println(canAttendMeetings(intervals1)); // false
        System.out.println(canAttendMeetings(intervals2)); // true
    }
}

