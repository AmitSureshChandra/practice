package com.dsa.practice.array;


import java.util.ArrayList;

/**
 * https://practice.geeksforgeeks.org/problems/peak-element/1/?page=1&difficulty[]=0&category[]=Arrays&sortBy=submissions
 */
public class PeakElement {

    public static void main(String[] args) {
        int[]a = new int[]{9, 14, 10, 10, 1, 2, 1, 7, 10, 10, 14, 19, 9};
        System.out.println(new PeakElement().peakElement(a, a.length));
    }

    // Function to find the peak element
    // arr[]: input array
    // n: size of array a[]
    public int peakElement(int[] arr,int n)
    {
        return getPeak(arr, n, 0, arr.length-1);
    }

    int getPeak(int[] arr, int n, int low, int high){

        int mid = (low + high)/2;

        if((mid == 0  || arr[mid] >= arr[mid - 1])&& (arr[mid] >= arr[mid+1] || mid == arr.length-1)){
            return mid;
        }
        else if(mid < arr.length - 1 && arr[mid] < arr[mid+1]){
            return getPeak(arr, n, mid+1 , high);
        }else{
            return getPeak(arr, n, low,mid - 1);
        }
    }
}
