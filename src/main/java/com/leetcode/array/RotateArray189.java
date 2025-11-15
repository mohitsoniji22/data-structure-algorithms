package com.leetcode.array;

import java.util.Arrays;

public class RotateArray189 {

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // Handle cases where k > n

        // Step 1: Reverse the entire array
        reverse(nums, 0, n - 1);
        // Step 2: Reverse the first k elements
        reverse(nums, 0, k - 1);
        // Step 3: Reverse the remaining n-k elements
        reverse(nums, k, n - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void rotateAlternate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // Handle cases where k > n
        int[] result = new int[n];

        // Place each element at its rotated position
        for (int i = 0; i < n; i++) {
            result[(i + k) % n] = nums[i];
        }

        // Copy back to original array
        for (int i = 0; i < n; i++) {
            nums[i] = result[i];
        }
    }

    // Main method to test the rotate function
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        System.out.println("Original Array: " + Arrays.toString(nums));
        //rotate(nums, k);
        rotateAlternate(nums, k);
        System.out.println("Rotated Array by " + k + " steps: " + Arrays.toString(nums));
    }
}
