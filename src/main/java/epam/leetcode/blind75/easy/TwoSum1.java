package epam.leetcode.blind75.easy;

import java.util.*;

public class TwoSum1 {
    public static int[] twoSum(int[] nums, int target) {
        var map = new HashMap<Integer, Integer>(); // value -> index

        for (var i = 0; i < nums.length; i++) {
            var complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[] {
                        map.get(complement), i
                };
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        var nums = new int[] { 2, 7, 11, 15 };
        var target = 9;
        var result = twoSum(nums, target);

        System.out.println(Arrays.toString(result)); // [0, 1]
    }
}
