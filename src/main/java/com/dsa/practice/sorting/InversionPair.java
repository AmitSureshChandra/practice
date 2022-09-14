package com.dsa.practice.sorting;

import java.util.Arrays;

/**
 * https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1
 */
public class InversionPair {

    public static void main(String[] args) {
        long[] arr = new long[]{2, 4, 1, 3, 5};
        long pairs = InversionPair.mergeSort(arr, 0,arr.length -1);
        System.out.println(pairs);
        System.out.println(Arrays.toString(arr));
    }

    static long mergeSort(long[] arr, int s, int e){
        // base cond
        if(s >= e){
            return 0l;
        }

        // recur
        int mid = (s + (e - s)/2);
        long leftCnt = mergeSort(arr, s, mid);
        long rightCnt = mergeSort(arr, mid+1, e);
        long cnt = merge(arr, s, mid , e);

        return leftCnt + cnt + rightCnt;
    }

    private static long merge(long[] arr, int l, int m, int r) {
        int f = 0;
        int s = 0;

        int ptr = l;

        long cnt = 0;

        long[] first = Arrays.copyOfRange(arr, l, m+1);
        long[] second = Arrays.copyOfRange(arr, m+1, r+1);

        while(f < first.length && s < second.length){
            if(first[f] <= second[s]){
                arr[ptr++] = first[f++];
            }else{
                arr[ptr++] = second[s++];
                cnt += (first.length - f);
            }
        }

        while(f < first.length){
            arr[ptr++] = first[f++];
        }

        while(s < second.length){
            arr[ptr++] = second[s++];
        }

        return cnt;
    }
}
