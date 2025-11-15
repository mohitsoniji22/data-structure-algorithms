package epam.leetcode.sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{87,3,5,12,9,45};
        mergeSort(arr, 0, arr.length-1);
        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void mergeSort(int[] arr, int l, int n) {
        if(l<n){
            int m = l+(n-l)/2;
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, n);

            mergeArray(arr, l, m, n);
        }
    }

    private static void mergeArray(int[] arr, int l, int m, int n){
        int n1 = m-l+1;
        int n2 = n-m;

        int[] ar1 = new int[n1];
        for(int i = 0; i<n1; i++){
            ar1[i] = arr[i+l];
        }

        int[] ar2 = new int[n2];
        for(int i = 0; i<n2; i++){
            ar2[i] = arr[i+m+1];
        }

        int i=0, j=0, k=l;
        while(i < n1 && j < n2) {
            if(ar1[i] <= ar2[j]){
                arr[k] = ar1[i];
                i++;
            } else {
                arr[k] = ar2[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = ar1[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = ar2[j];
            j++;
            k++;
        }
    }
}
