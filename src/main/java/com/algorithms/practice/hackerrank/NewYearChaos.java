package main.java.com.algorithms.practice.hackerrank;

import java.util.Arrays;
import java.util.BitSet;

public class NewYearChaos {
    private static int merge(int arr[], int temp[], int left, int mid, int right)
    {
        int inv_count = 0;

        int i = left;
        int j = mid;
        int k = left;
        while ((i <= mid - 1) && (j <= right))
        {
            if (arr[i] <= arr[j])
                temp[k++] = arr[i++];
            else
            {
                temp[k++] = arr[j++];
                inv_count = inv_count + (mid - i);
            }
        }
        while (i <= mid - 1)
            temp[k++] = arr[i++];
        while (j <= right)
            temp[k++] = arr[j++];
        for (i=left; i <= right; i++)
            arr[i] = temp[i];

        return inv_count;
    }
    private static int mergeSort(int[] arr, int[] temp, int left, int right)
    {
        int mid, inv_count = 0;
        if (right > left)
        {
            mid = (right + left)/2;
            inv_count = mergeSort(arr, temp, left, mid);
            inv_count += mergeSort(arr, temp, mid+1, right);
            inv_count += merge(arr, temp, left, mid+1, right);
        }

        return inv_count;
    }
    private static int countSwaps(int[] arr)
    {
        int[] temp = new int[arr.length];
        return mergeSort(arr, temp, 0, arr.length - 1);
    }
    private static int solve(int[] A){
        int[] good = new int[A.length + 1];
        int i = 0;
        for(int a: A){
            good[a] = (i + 1) - a;
            if(good[a] < -2){
                return -1;
            }
            i++;
        }
        return countSwaps(A);
    }

    static void minimumBribes(int[] q) {
        int ans = solve(q);
        System.out.println((ans == -1 ? "Too chaotic" : ans));
    }

    public static void main(String[] args) {

        //12345
        //21345
        //21354
        //21534
        //21543
        solve(new int[]{2 ,1 ,5 ,4, 3});
        minimumBribes(new int[]{1, 2, 5, 3, 7, 8, 6,4});//1 2 5 3 7 8 6 4
    }
}
