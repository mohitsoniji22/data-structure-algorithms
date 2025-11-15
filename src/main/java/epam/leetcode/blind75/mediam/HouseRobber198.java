package epam.leetcode.blind75.mediam;

public class HouseRobber198 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int prev2 = nums[0];               // dp[i-2]
        int prev1 = Math.max(nums[0], nums[1]);  // dp[i-1]

        for (int i = 2; i < nums.length; i++) {
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
