package com.leetcode.blind75.mediam;

public class HouseRobberII213 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        return Math.max(
                robRange(nums, 0, n - 2),  // exclude last
                robRange(nums, 1, n - 1)   // exclude first
        );
    }

    private int robRange(int[] nums, int start, int end) {
        if (start == end) return nums[start];

        int prev2 = nums[start];
        int prev1 = Math.max(nums[start], nums[start + 1]);

        for (int i = start + 2; i <= end; i++) {
            int curr = Math.max(nums[i] + prev2, prev1);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    // Test
    public static void main(String[] args) {
        HouseRobber198 s = new HouseRobber198();

        int[] nums1 = {5,2,3,25};
        System.out.println(s.rob(nums1)); // 4

        int[] nums2 = {2,7,9,3,1};
        System.out.println(s.rob(nums2)); // 12

        int[] nums3 = {2,1,1,2};
        System.out.println(s.rob(nums3)); // 4
    }
}
