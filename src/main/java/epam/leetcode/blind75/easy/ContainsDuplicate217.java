package epam.leetcode.blind75.easy;

import java.util.HashSet;
import java.util.Set;

/*
217. Contains Duplicate
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

 */
public class ContainsDuplicate217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (!seen.add(num)) { // add() returns false if element already exists
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate217 obj = new ContainsDuplicate217();
        int[] nums = {1, 2, 3, 1};
        System.out.println(obj.containsDuplicate(nums)); // true
    }
}

