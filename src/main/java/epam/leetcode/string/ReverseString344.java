package epam.leetcode.string;

public class ReverseString344 {

    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            // Swap characters
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            // Move pointers
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o', 'i'};

        System.out.println("Before reversing: " + String.valueOf(s));
        reverseString(s);
        System.out.println("After reversing:  " + String.valueOf(s));
    }
}

