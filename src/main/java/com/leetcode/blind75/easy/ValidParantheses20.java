package com.leetcode.blind75.easy;


import java.util.Stack;

public class ValidParantheses20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else {
                // If stack is empty or top doesn't match current closing
                if (stack.isEmpty() || stack.pop() != c) return false;
            }
        }

        return stack.isEmpty(); // all open brackets must be closed
    }

    public static void main(String[] args) {
        ValidParantheses20 sol = new ValidParantheses20();
        System.out.println(sol.isValid("()"));       // true
        System.out.println(sol.isValid("()[]{}"));   // true
        System.out.println(sol.isValid("(]"));       // false
        System.out.println(sol.isValid("([{}])"));   // true
        System.out.println(sol.isValid("([)]"));     // false
    }
}

