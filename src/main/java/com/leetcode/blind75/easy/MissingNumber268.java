package com.leetcode.blind75.easy;

/*
    * 268. Missing Number
    * https://leetcode.com/problems/missing-number/
    * Easy
    * Given an array nums containing n distinct numbers in the range [0, n], return the only number
    * in the range that is missing from the array.
    * Example 1:
    * Input: nums = [3,0,1]
    * Output: 2
    *
 */
public class MissingNumber268 {

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;

        for (int num : nums) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }

    /*
    Key XOR properties:
        a ^ a = 0 → same numbers cancel out
        a ^ 0 = a → XOR with 0 gives the same number
        a ^ b ^ a = b → order doesn’t matter (commutative + associative)
     */
    public int missingNumberXOR(int[] nums) {
        int n = nums.length;
        int result = n; // start with n, since range is [0..n]

        for (int i = 0; i < n; i++) {
            result ^= i ^ nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        MissingNumber268 obj = new MissingNumber268();
        int[] nums = {3, 0, 1};
        System.out.println(obj.missingNumber(nums)); // Output: 2

        System.out.println(obj.missingNumberXOR(nums)); // Output: 2
    }
}
