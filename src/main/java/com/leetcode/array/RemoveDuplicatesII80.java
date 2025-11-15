package com.leetcode.array;

import java.util.Arrays;

public class RemoveDuplicatesII80 {

    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;

        int i = 2; // Start from 2 because first two are always allowed

        for (int j = 2; j < nums.length; j++) {
            if (nums[j] != nums[i - 2]) {
                nums[i] = nums[j];
                i++;
            }
        }

        return i;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        int k = removeDuplicates(nums);
        System.out.println("k = " + k);
        System.out.println(Arrays.toString(Arrays.copyOf(nums, k)));
    }
}

