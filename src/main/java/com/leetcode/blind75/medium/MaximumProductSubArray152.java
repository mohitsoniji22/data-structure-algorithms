package com.leetcode.blind75.medium;

public class MaximumProductSubArray152 {
    public int maxProduct(int[] nums) {
        int maxProd = nums[0];
        int minProd = nums[0];
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];

            // If curr is negative, swap maxProd and minProd
            if (curr < 0) {
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }

            maxProd = Math.max(curr, maxProd * curr);
            minProd = Math.min(curr, minProd * curr);

            ans = Math.max(ans, maxProd);
        }

        return ans;
    }

    public int maxProductBruteForce(int[] nums) {
        int n = nums.length;
        int maxProduct = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int currentProduct = 1;

            for (int j = i; j < n; j++) {
                currentProduct *= nums[j];
                maxProduct = Math.max(maxProduct, currentProduct);
            }
        }

        return maxProduct;
    }

    public static void main(String[] args) {
        MaximumProductSubArray152 solver = new MaximumProductSubArray152();
        int[] nums = {2, 1, -2, 4};
        int result = solver.maxProduct(nums);
        System.out.println("Maximum Product Subarray = " + result);

        int result1 = solver.maxProductBruteForce(nums);
        System.out.println("Maximum Product Subarray Brute Force = " + result1);
    }
}

