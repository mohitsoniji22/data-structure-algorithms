package epam.leetcode.blind75.mediam;

public class SearchRotatedSortedArray33 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Left half is sorted
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // Right half is sorted
            else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1; // Not found
    }

    public static void main(String[] args) {
        SearchRotatedSortedArray33 solver = new SearchRotatedSortedArray33();
        int[] nums = {4,5,6,7,0,1,2};
        int target = 6;
        int result = solver.search(nums, target);
        System.out.println("Index of target " + target + " is: " + result); // Output: 4
    }
}
