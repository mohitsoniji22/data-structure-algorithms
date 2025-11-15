package com.leetcode.blind75.mediam;

public class LongestIncreasingSubsequene300 {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;

        for (int num : nums) {
            int left = 0, right = size;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (tails[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            tails[left] = num;

            if (left == size) size++;
        }

        return size;
    }

    /*public int lengthOfLIS2(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        List<Integer> lis = new ArrayList<>();
        for(int num : nums) {
            if(lis.isEmpty() || num > lis.get(lis.size() - 1)) {
                lis.add(num);
            } else {
                int index = binarySearch(lis, num);
                lis.set(index, num);
            }
        }
    }*/

    public static void main(String[] args) {
        LongestIncreasingSubsequene300 solver = new LongestIncreasingSubsequene300();

        int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18, 10, 11, 12, 13};
        System.out.println(solver.lengthOfLIS(nums1)); // Output: 4

        /*int[] nums2 = {0, 1, 0, 3, 2, 3};
        System.out.println(solver.lengthOfLIS(nums2)); // Output: 4

        int[] nums3 = {7, 7, 7, 7, 7, 7, 7};
        System.out.println(solver.lengthOfLIS(nums3)); // Output: 1*/
    }
}
