package com.leetcode.string;

public class IndexOfFirstOccurance28 {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        if (m == 0) return 0; // empty needle -> return 0
        if (m > n) return -1;

        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            if (j == m) return i; // full match found
        }
        return -1;
    }

    public static void main(String[] args) {
        IndexOfFirstOccurance28 sol = new IndexOfFirstOccurance28();
        System.out.println(sol.strStr("sadbutsad", "sad")); // Output: 0
        System.out.println(sol.strStr("leetcode", "leeto")); // Output: -1
    }
}
