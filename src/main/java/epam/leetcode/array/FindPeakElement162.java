package epam.leetcode.array;

/*
162. Find Peak Element
A peak element is an element that is strictly greater than its neighbors.
Given an integer array nums, find a peak element, and return its index.
If the array contains multiple peaks, return the index to any of the peaks.
You may imagine that nums[-1] = nums[n] = -∞.
You must write an algorithm that runs in O(log n) time.

 */
public class FindPeakElement162 {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1]) {
                // You are in the descending part of the array.
                // This means the peak is to the left (including mid).
                right = mid;
            } else {
                // You are in the ascending part of the array.
                // This means the peak is to the right.
                left = mid + 1;
            }
        }

        // At the end of the while loop, left == right pointing to the peak element.
        return left;
    }

    public static void main(String[] args) {
        FindPeakElement162 solver = new FindPeakElement162();
        int[] nums = {1,2,1,3,5,6,4};
        int result = solver.findPeakElement(nums);
        System.out.println("Peak element index is: " + result); // Output: 2
    }
}
