package epam.leetcode.array;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MedianOfTwoSortedArrays4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // ensure nums1 is smaller
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int low = 0, high = m;

        while (low <= high) {
            int i = (low + high) / 2;
            int j = (m + n + 1) / 2 - i;

            int maxLeft1 = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int minRight1 = (i == m) ? Integer.MAX_VALUE : nums1[i];

            int maxLeft2 = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int minRight2 = (j == n) ? Integer.MAX_VALUE : nums2[j];

            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // correct partition found
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                } else {
                    return Math.max(maxLeft1, maxLeft2);
                }
            } else if (maxLeft1 > minRight2) {
                high = i - 1; // move left
            } else {
                low = i + 1; // move right
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted properly.");
    }

    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int[] sorted = IntStream.concat(Arrays.stream(nums1), Arrays.stream(nums2)).sorted().toArray();
        if(sorted.length % 2 == 1) {
            return sorted[sorted.length / 2];
        } else {
            return (sorted[sorted.length / 2] + sorted[(sorted.length / 2) - 1]) / 2.0;
        }
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays4 solver = new MedianOfTwoSortedArrays4();

        int[] nums1 = {1, 3};
        int[] nums2 = {2, 4, 5, 6};

        double median = solver.findMedianSortedArrays(nums1, nums2);
        System.out.println("Median = " + median);  // Output: 3.5
    }
}

