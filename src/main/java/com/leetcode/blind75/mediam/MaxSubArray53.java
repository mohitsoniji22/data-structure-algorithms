package com.leetcode.blind75.mediam;

public class MaxSubArray53 {

    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = 0;

        for (int num : nums) {
            currentSum += num;
            maxSum = Math.max(maxSum, currentSum);

            if (currentSum < 0) {
                currentSum = 0; // reset if sum goes negative
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int result = new MaxSubArray53().maxSubArray(nums);

        System.out.println("Maximum Subarray Sum = " + result);
    }
}
