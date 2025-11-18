package com.leetcode.blind75.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElement347 {
    public static int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequencies
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Step 2: Min-heap of size k (stores {num, freq})
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                    (a, b) -> a[1] - b[1]   // sort by frequency ascending
        );

        // Push into heap
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            pq.add(new int[]{e.getKey(), e.getValue()});
            if (pq.size() > k) {
                pq.poll(); // remove smallest frequency
            }
        }

        // Step 3: Build result
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = pq.poll()[0];
        }

        return result;
    }
}
