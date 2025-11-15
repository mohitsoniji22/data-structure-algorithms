package epam.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring76 {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // Count characters in t
        Map<Character, Integer> dictT = new HashMap<>();
        for (char c : t.toCharArray()) {
            dictT.put(c, dictT.getOrDefault(c, 0) + 1);
        }

        int required = dictT.size(); // unique characters to match
        int formed = 0;

        Map<Character, Integer> windowCounts = new HashMap<>();
        int l = 0, r = 0;
        int[] ans = {-1, 0, 0}; // length, left, right

        while (r < s.length()) {
            char c = s.charAt(r);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                formed++;
            }

            // Try to contract the window
            while (l <= r && formed == required) {
                c = s.charAt(l);

                // Update answer
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                // Remove char from window
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                    formed--;
                }

                l++;
            }

            r++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }

    // For testing
    public static void main(String[] args) {
        MinimumWindowSubstring76 sol = new MinimumWindowSubstring76();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(sol.minWindow(s, t)); // Output: "BANC"
    }
}

