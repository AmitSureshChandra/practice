package com.dsa.practice.array;

public class BitonicPoint {
    public static void main(String[] args) {
        System.out.println(new BitonicPoint().findMaximum(new int[] {1,2,3,4,3,2}, 6));
    }

    int findMaximum(int[] arr, int n) {
        int l = 0;
        int r = arr.length - 1;

        while(l <= r){

            int mid = l + (r - l)/2;

            if(mid > 0 && mid < arr.length -1 && arr[mid] > arr[mid+1] && arr[mid] > arr[mid-1]){
                return arr[mid];
            }

            if(mid == 0){
                if(arr[mid] > arr[mid+1]){
                    return arr[mid];
                }
            }

            if(mid == arr.length -1){
                if(arr[mid] > arr[mid-1]){
                    return arr[mid];
                }
            }

            if(l == r-1){
                if(arr[l] < arr[r]){
                    return arr[r];
                }else{
                    return arr[l];
                }
            }

            if(arr[mid] < arr[mid + 1]){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }

        return -1;

    }
}
