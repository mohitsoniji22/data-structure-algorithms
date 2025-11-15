package epam.leetcode.array;

import java.util.Random;

public class RandomPickWithWeight528 {

    private int[] prefix;
    private int total;
    private Random rand;

    public RandomPickWithWeight528(int[] w) {
        prefix = new int[w.length];
        prefix[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            prefix[i] = prefix[i - 1] + w[i];
        }
        total = prefix[prefix.length - 1];
        rand = new Random();
    }

    public int pickIndex() {
        int target = rand.nextInt(total) + 1; // random number between 1 and total
        int left = 0, right = prefix.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (prefix[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] w = {1, 3, 2};
        RandomPickWithWeight528 obj = new RandomPickWithWeight528(w);

        // pick 10 samples
        for (int i = 0; i < 10; i++) {
            System.out.print(obj.pickIndex() + " ");
        }
    }
}
