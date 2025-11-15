package com.leetcode.blind75.mediam;

import java.util.Arrays;

public class LongestConsecutiveSequence128 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Arrays.sort(nums);
        int maxLength = 1;
        int currentLength = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) { // Skip duplicates
                if (nums[i] == nums[i - 1] + 1) {
                    currentLength++;
                } else {
                    maxLength = Math.max(maxLength, currentLength);
                    currentLength = 1;
                }
            }
        }
        maxLength = Math.max(maxLength, currentLength);
        return maxLength;
    }
    public int mySolutionlongestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        int[] newNum = Arrays.stream(nums).distinct().sorted().toArray();
        int maxCount=1, count=1;
        for(int i=1; i<newNum.length; i++) {
            if(newNum[i] == (newNum[i-1]+1)) {
                count++;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 1;
            }
        }
        maxCount = Math.max(maxCount, count);
        count = 1;
        return maxCount;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence128 solver = new LongestConsecutiveSequence128();
        int[] nums = {100,4,200,1,3,2};
        int result = solver.longestConsecutive(nums);
        System.out.println("Longest Consecutive Sequence Length = " + result); // Output: 4
    }
}
