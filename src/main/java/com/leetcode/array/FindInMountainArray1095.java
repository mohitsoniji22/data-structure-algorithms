package com.leetcode.array;

interface MountainArray {
    public int get(int index);
    public int length();
}

// Mock implementation for local testing
class MountainArrayImpl implements MountainArray {
    private int[] arr;
    public MountainArrayImpl(int[] arr) {
        this.arr = arr;
    }
    public int get(int index) {
        return arr[index];
    }
    public int length() {
        return arr.length;
    }
}

public class FindInMountainArray1095 {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();

        // 1️⃣ Find peak
        int peak = findPeak(mountainArr, n);

        // 2️⃣ Search left (ascending)
        int index = binarySearch(mountainArr, target, 0, peak, true);
        if (index != -1) return index;

        // 3️⃣ Search right (descending)
        return binarySearch(mountainArr, target, peak + 1, n - 1, false);
    }

    private int findPeak(MountainArray arr, int n) {
        int low = 0, high = n - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr.get(mid) < arr.get(mid + 1))
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    private int binarySearch(MountainArray arr, int target, int low, int high, boolean asc) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int val = arr.get(mid);

            if (val == target) return mid;

            if (asc) {
                if (val < target) low = mid + 1;
                else high = mid - 1;
            } else {
                if (val > target) low = mid + 1;
                else high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] mountain = {1, 3, 5, 7, 6, 4, 2};
        MountainArray mountainArr = new MountainArrayImpl(mountain);

        FindInMountainArray1095 solver = new FindInMountainArray1095();

        int target = 4;
        int index = solver.findInMountainArray(target, mountainArr);

        System.out.println("Target: " + target);
        System.out.println("Index Found: " + index);

    }
}

