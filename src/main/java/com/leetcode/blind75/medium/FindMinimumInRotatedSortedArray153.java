package com.leetcode.blind75.medium;

import java.util.Arrays;

public class FindMinimumInRotatedSortedArray153 {
    public int findMin(int[] nums) {
        return Arrays.stream(nums).min().getAsInt();
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray153 solver = new FindMinimumInRotatedSortedArray153();
        int[] nums = {3, 4, 5, 1, 2};
        int result = solver.findMin(nums);
        System.out.println("Minimum element is: " + result); // Output: 1
    }
}
