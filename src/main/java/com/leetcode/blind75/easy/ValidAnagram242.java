package com.leetcode.blind75.easy;

import java.util.Arrays;
/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

👉 An anagram means both strings contain the same characters with the same frequency, but possibly in a different order.
 */
public class ValidAnagram242 {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a, b);
    }

    public static void main(String[] args) {
        ValidAnagram242 obj = new ValidAnagram242();
        System.out.println(obj.isAnagram("anagram", "nagaram")); // true
        System.out.println(obj.isAnagram("rat", "car"));         // false
    }
}

