package com.leetcode.blind75.medium;

public class LongestRepeatingCharacterReplacement424 {

    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];

        int left = 0;
        int maxFreq = 0;
        int result = 0;

        for (int right = 0; right < s.length(); right++) {

            freq[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            int window = right - left + 1;

            // If replacements needed > k → shrink window
            if (window - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
                window--;
            }

            result = Math.max(result, window);
        }

        return result;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement424 sol = new LongestRepeatingCharacterReplacement424();

        String s = "AABABBA";
        int k = 1;

        int ans = sol.characterReplacement(s, k);

        System.out.println("Longest repeating character replacement length = " + ans);

    }

}
