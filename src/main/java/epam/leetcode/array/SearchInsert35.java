package epam.leetcode.array;

public class SearchInsert35 {

    public int searchInsert(int[] nums, int target) {
        int order = 0;
        boolean orderFound = false;
        for(int i=0; i<nums.length; i++) {
            if(target == nums[i]) {
                return i;
            } else if(!orderFound && target < nums[i]){
                order = Math.max(order, i);
                orderFound = true;
            }
        }
        if(!orderFound) {
            order = nums.length;
        }
        return order;
    }

    public static void main(String[] args) {
        SearchInsert35 solver = new SearchInsert35();
        int[] nums = {1,3,5,6};
        int target = 7;
        int result = solver.searchInsert(nums, target);
        System.out.println("Insert position: " + result); // Output: 2
    }
}
