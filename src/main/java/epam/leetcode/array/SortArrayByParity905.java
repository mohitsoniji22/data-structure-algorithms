package epam.leetcode.array;

import java.util.Arrays;

public class SortArrayByParity905 {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            if (nums[left] % 2 > nums[right] % 2) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }

            if (nums[left] % 2 == 0) left++;
            if (nums[right] % 2 == 1) right--;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,2,4};
        int[] result = new SortArrayByParity905().sortArrayByParity(nums);
        System.out.println(Arrays.toString(result)); // [4, 2, 1, 3] or [2,4,3,1]
    }
}
