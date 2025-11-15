package epam.leetcode.array;

/*
Question:
Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that
each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of
unique elements in nums.
 */
/*
Approach:
1. Use two pointers: one for iterating through the array (j) and one for tracking the position of the last unique element (i).
2. Iterate through the array with pointer j.
3. Whenever a new unique element is found (nums[j] != nums[i]), increment i and update nums[i] with nums[j].
4. After the loop, the first i + 1 elements in the array will be the unique elements.
5. Return i + 1 as the count of unique elements.
//                 }
//             }
//         }
//
 */
public class RemoveDuplicates26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 0; // points to last unique element

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1; // number of unique elements
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        RemoveDuplicates26 rd = new RemoveDuplicates26();
        int k = rd.removeDuplicates(nums);

        System.out.println("k = " + k);
        System.out.print("Array after removing duplicates: ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}

