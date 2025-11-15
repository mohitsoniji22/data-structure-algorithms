package epam.leetcode.blind75.mediam;

public class MaximumProductSubArray152 {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                // Swap max and min when multiplied by a negative number
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            maxProduct = Math.max(nums[i], maxProduct * nums[i]);
            minProduct = Math.min(nums[i], minProduct * nums[i]);

            result = Math.max(result, maxProduct);
        }

        return result;
    }

    public static void main(String[] args) {
        MaximumProductSubArray152 solver = new MaximumProductSubArray152();
        int[] nums = {2,1,-2,4};
        int result = solver.maxProduct(nums);
        System.out.println("Maximum Product Subarray = " + result);
    }
}

