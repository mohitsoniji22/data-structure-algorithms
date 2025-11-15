package epam.leetcode.string;

import java.util.Stack;

public class LongestValidParentheses32 {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // base index for valid substring calculation
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else { // c == ')'
                stack.pop(); // pop matching '(' index (or base)
                if (stack.isEmpty()) {
                    // no base to measure from, set new base to current index
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestValidParentheses32 sol = new LongestValidParentheses32();
        System.out.println(sol.longestValidParentheses("(()"));     // 2
        System.out.println(sol.longestValidParentheses(")()())"));  // 4
        System.out.println(sol.longestValidParentheses("()(()))()"));// 6
    }
}
