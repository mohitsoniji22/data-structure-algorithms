package com.leetcode.array;

/*
Que:
Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"
 */

/*
Approach 2 — Horizontal Scanning

Take the first string as prefix.
Compare it with each next string and shrink the prefix until it matches.
 */
public class LongestCommonPrefix14 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        var prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty())
                    return "";
            }
        }

        return prefix;
    }

    public static void main(String[] args) {
        var input1 = new String[]{"flower", "flow", "flight"};
        //var input2 = new String[]{"dog", "racecar", "racar"};

        System.out.println(longestCommonPrefix(input1)); // fl
        //System.out.println(longestCommonPrefix(input2)); // ""
    }
}
