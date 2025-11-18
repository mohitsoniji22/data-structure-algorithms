package com.leetcode.blind75.medium;

import java.util.*;

/*
Que:
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.
*/

/*
2️⃣ Optimized Two-Pointer Approach (O(n²))

This is the standard and most efficient solution.

Steps:

Sort the array — this helps in skipping duplicates easily.

Fix one number nums[i], and then use two pointers (left and right) to find pairs that sum to -nums[i].

Move pointers inward based on the sum:

If sum < 0 → increase left

If sum > 0 → decrease right

If sum == 0 → record the triplet

Skip duplicate numbers for both i, left, and right.
 */
public class ThreeSum15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // Step 1: sort
        var result = new ArrayList<List<Integer>>();

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate values for i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(List.of(nums[i], nums[left], nums[right]));

                    // Skip duplicate left values
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    // Skip duplicate right values
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;  // Need larger sum
                } else {
                    right--; // Need smaller sum
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        var nums = new int[]{-1, 0, 1, 2, -1, -4};
        var result = threeSum(nums);
        System.out.println(result); // [[-1, -1, 2], [-1, 0, 1]]
    }
}
