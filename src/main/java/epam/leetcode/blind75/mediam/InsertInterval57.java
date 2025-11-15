package epam.leetcode.blind75.mediam;

import java.util.*;

public class InsertInterval57 {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();

        for (int[] interval : intervals) {
            if (interval[1] < newInterval[0]) {
                // Current interval is completely before newInterval
                res.add(interval);
            } else if (interval[0] > newInterval[1]) {
                // Current interval is completely after newInterval
                res.add(newInterval);
                newInterval = interval; // update newInterval
            } else {
                // Overlapping intervals → merge
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }

        // Add the last newInterval
        res.add(newInterval);

        return res.toArray(new int[res.size()][]);
    }

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

    public static int[][] add(int[][] intervals, int[] newInterval) {
        int[][] combined = new int[intervals.length + 1][2];
        for (int i = 0; i < intervals.length; i++) {
            combined[i] = intervals[i];
        }
        combined[intervals.length] = newInterval;
        return merge(combined);
    }



    public static void main(String[] args) {
        /*int[][] intervals = {{1,3},{6,9}};
        int[] newInterval = {2,5};

        int[][] result = insert(intervals, newInterval);

        System.out.print("Result: ");
        for (int[] interval : result) {
            System.out.print(Arrays.toString(interval) + " ");
        }*/

        int[][] intervals = {{1,3},{6,9}};
        int[] newInterval = {2,5};

        //First add new interval to intervals and then sort and merge them using MergeInterval56
        int[][] result = add(intervals, newInterval);

        System.out.print("Result: ");
        for (int[] interval : result) {
            System.out.print(Arrays.toString(interval) + " ");
        }
    }
}
