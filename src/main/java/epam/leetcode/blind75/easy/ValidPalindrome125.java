package epam.leetcode.blind75.easy;

public class ValidPalindrome125 {
    public boolean isPalindrome(String s) {
        String str = s.replaceAll("\\s+", "");
        int left = 0, right = str.length() - 1;

        while (left < right) {
            // Skip non-alphanumeric characters
            while (left < right && !Character.isLetterOrDigit(str.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(str.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(str.charAt(left)) != Character.toLowerCase(str.charAt(right))) {
                return false;
            }

            left++;
            right--;
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

