package epam.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/*
    * 22. Generate Parentheses
    * Medium
    * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
    * Example 1:
    * Input: n = 3
    * Output: ["((()))","(()())","(())()","()(())","()()()"]
    * Example 2:
    * Input: n = 1
    * Output: ["()"]
 */
public class generateParenthesis22 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, String current, int open, int close, int max) {
        if (current.length() == 2 * max) {
            result.add(current);
            return;
        }
        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        generateParenthesis22 sol = new generateParenthesis22();
        System.out.println(sol.generateParenthesis(4));
    }
}
