package com.leetcode.blind75.mediam;

import java.util.Arrays;

public class MeetingRoomsII253 {

    public static int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) return 0;

        int n = intervals.length;

        // Step 1: Separate start and end times
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        // Step 2: Sort both arrays
        Arrays.sort(start);
        Arrays.sort(end);

        // Step 3: Use two pointers
        int s = 0, e = 0;
        int rooms = 0, maxRooms = 0;

        while (s < n) {
            if (start[s] < end[e]) {
                rooms++;        // need a new room
                s++;
            } else {
                rooms--;        // one meeting ended
                e++;
            }
            maxRooms = Math.max(maxRooms, rooms);
        }

        return maxRooms;
    }

    public static void main(String[] args) {
        int[][] intervals1 = {{0,30},{5,10},{15,20}};
        int[][] intervals2 = {{7,10},{2,4}};
        int[][] intervals3 = {{1,5},{2,6},{5,7},{7,8}};

        System.out.println(minMeetingRooms(intervals1)); // 2
        System.out.println(minMeetingRooms(intervals2)); // 1
        System.out.println(minMeetingRooms(intervals3)); // 2
    }
}

