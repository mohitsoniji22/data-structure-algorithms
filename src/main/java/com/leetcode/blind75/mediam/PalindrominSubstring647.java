package com.leetcode.blind75.mediam;

public class PalindrominSubstring647 {

    public int countSubstrings(String s) {
        int count = 0;

        for (int center = 0; center < 2 * s.length() - 1; center++) {

            int left = center / 2;
            int right = left + center % 2;

            // expand around center
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        PalindrominSubstring647 sol = new PalindrominSubstring647();

        String s = "abc";

        int result = sol.countSubstrings(s);

        System.out.println("Total palindromic substrings = " + result);
    }

}
