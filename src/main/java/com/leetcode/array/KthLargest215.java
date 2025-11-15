package com.leetcode.array;

import java.util.PriorityQueue;

public class KthLargest215 {

    public static void FirstSecondThirdLargestBruteForce(String[] args) {
        int arr[] = { 12, 11, 13, 5, 6, 48, 23, 12, 4 };
        int first=0, second=0, third=0;
        for(int i=0; i< arr.length; i++){
            if(arr[i] > first) {
                third = second;
                second = first;
                first = arr[i];
            } else if(arr[i] > second) {
                third = second;
                second = arr[i];
            } else if(arr[i] > third) {
                third = arr[i];
            }
        }
        System.out.println("First: "+first + ", Second: "+second + ", Third: "+third);
    }

    public static int findKthLargest(int[] nums, int k) {
        // Min-heap to keep track of top k elements
        //That means the smallest element is always at the top (root).
        //This is Min Heap by default in Java PriorityQueue
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int num : nums) {
            heap.add(num);
            if (heap.size(  ) > k) {
                heap.poll(); // remove smallest to maintain k elements
            }
        }

        return heap.peek(); // root is the kth largest
    }

    /*
    MaxHeap using Priority Queue
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
     */

    public static void main(String[] args) {
        int[] nums = {10, 4, 3, 50, 23, 90};
        int k = 4; // find 3rd largest element
        System.out.println("3rd Largest Element: " + findKthLargest(nums, k));
        FirstSecondThirdLargestBruteForce(args);
    }
}
