package com.leetcode.string;

public class ReverseWordsInString151 {

    public static String reverseWords(String s) {
        // Step 1: Remove leading and trailing spaces
        s = s.trim();

        // Step 2: Split words by one or more spaces
        String[] words = s.split("\\s+");

        // Step 3: Reverse the words
        StringBuilder reversed = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i > 0) reversed.append(" "); // Add space between words
        }

        // Step 4: Return result
        return reversed.toString();
    }

    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println("Input: \"" + s + "\"");
        String result = reverseWords(s);
        System.out.println("Output: \"" + result + "\"");
    }
}

