package epam.leetcode.array;

import java.util.Arrays;

public class KokoEatingBananas875 {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFinish(piles, h, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
    private boolean canFinish(int[] piles, int h, int speed) {
        int hoursNeeded = 0;
        for (int pile : piles) {
            hoursNeeded = hoursNeeded + (pile + speed - 1) / speed; // Equivalent to Math.ceil((double)pile / speed)
        }
        return hoursNeeded <= h;
    }

    public static void main(String[] args) {
        KokoEatingBananas875 solver = new KokoEatingBananas875();
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        int result = solver.minEatingSpeed(piles, h);
        System.out.println("Minimum eating speed: " + result); // Output: 4
    }
}
