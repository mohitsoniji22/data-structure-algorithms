package com.leetcode.blind75.medium;

public class ProductOfArrayExceptSelf238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Step 1: Build prefix products
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Step 2: Multiply by suffix products (right to left)
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= suffix;
            suffix *= nums[i];
        }

        return result;
    }

    public int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int product = 1;
        for(int num : nums) {
            product *= num;
        }

        for(int i = 0; i < n; i++) {
            if(nums[i] != 0)
                nums[i] = product / nums[i];
            else
                nums[i] = product;
        }

        return nums;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf238 solver = new ProductOfArrayExceptSelf238();
        int[] nums = {1, 2, 3, 4};
        int[] result = solver.productExceptSelf(nums);

        for (int val : result) {
            System.out.print(val + " ");  // Output: 24 12 8 6
        }
    }
}

