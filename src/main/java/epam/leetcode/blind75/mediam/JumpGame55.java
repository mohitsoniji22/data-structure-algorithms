package epam.leetcode.blind75.mediam;

/*
    * Problem: Jump Game
    * Link: https://leetcode.com/problems/jump-game/
    * Difficulty: Medium
    * Topic: Array, Greedy
    * Description:
    * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
    * Each element in the array represents your maximum jump length at that position.
    * Determine if you are able to reach the last index.
    * Example 1:
    * Input: nums = [2,3,1,1,4]
    * Output: true
    * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
    * Example 2:
    * Input: nums = [3,2,1,0,4]
    * Output: false
    * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
*/
public class JumpGame55 {

    public static boolean canJump(int[] nums) {
        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) return false; // can't move forward
            maxReach = Math.max(maxReach, i + nums[i]);
        }

        return true;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 1, 4};
        int[] nums2 = {3, 2, 1, 0, 4};

        System.out.println("Can jump (nums1): " + canJump(nums1)); // true
        System.out.println("Can jump (nums2): " + canJump(nums2)); // false
    }
}
