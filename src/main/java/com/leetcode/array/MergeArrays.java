package com.leetcode.array;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MergeArrays {
    public static void main(String[] args) {
        int arr1[] = new int[] { 1, 5, 9, 10, 15, 20 };
        int arr2[] = new int[] { 2, 3, 8, 13 };

        IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).sorted().forEach(System.out::println);
    }
}
