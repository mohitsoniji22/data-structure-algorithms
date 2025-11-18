package com.leetcode.blind75.medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;  // empty string is always valid

        // Put dictionary words in HashSet for O(1) lookup
        Set<String> set = new HashSet<>(wordDict);

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                String sub = s.substring(j, i);

                if (dp[j] && set.contains(sub)) {
                    dp[i] = true;
                    break; // no need to check further
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        WordBreak139 solver = new WordBreak139();
        String s = "catsanddog";
        List<String> wordDict = List.of("cats","dog","sand","and","cat");
        boolean result = solver.wordBreak(s, wordDict);
        System.out.println("Can the string be segmented? " + result);
    }
}
