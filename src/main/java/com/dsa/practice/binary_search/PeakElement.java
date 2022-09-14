package com.dsa.practice.binary_search;

/**
 * https://leetcode.com/problems/find-peak-element/
 */
public class PeakElement {
    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{1,2,3,1}));
    }
    public static int findPeakElement(int[] arr) {

        int n = arr.length;
        int low = 0;
        int high = n-1;

        if(n ==1){
            return 0;
        }

        while(low <= high){

            int mid = low + (high - low)/2;

            if(mid == 0 ){

                if(arr[mid] > arr[mid + 1]){
                    return mid;
                }else{
                    return mid+1;
                }
            }

            if(mid == n-1 ){
                if(arr[mid] > arr[mid - 1])
                    return mid;
                else
                    return mid-1;
            }

            if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]){
                return mid;
            }

            if(low == high -1){
                if(arr[high] > arr[low]){
                    return high;
                }else{
                    return low;
                }
            }

            if(arr[mid] < arr[mid +1] && arr[mid] > arr[mid - 1]){
                low = mid;
            }else{
                high = mid;
            }
        }

        return -1;
    }
}
