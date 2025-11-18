package com.leetcode.blind75.easy;

public class ValidPalindrome125 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^A-Za-z0-9]", "");
        int left = 0, right = s.length()-1;

        while(left<=right) {
            if(s.charAt(left) != s.charAt(right))
                return false;
            else {
                left++;
                right--;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome125 solver = new ValidPalindrome125();
        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";

        System.out.println(solver.isPalindrome(s1)); // true
        System.out.println(solver.isPalindrome(s2)); // false
    }
}

