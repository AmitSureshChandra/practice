package com.dsa.practice.binary_search;

/**
 * https://practice.geeksforgeeks.org/problems/element-appearing-once2552/1
 */
public class FindElementAppearsOnce {
    public static void main(String[] args) {
        System.out.println(search(new int[]{1,2,2,3,3}, 5));
        System.out.println(search(new int[]{1,1,2,3,3}, 5));
        System.out.println(search(new int[]{1,1,2,2,3}, 5));
    }
    public static int search(int[] arr, int N)
    {
        // your code here

        int low = 0;
        int high = arr.length-1;

        if(N==1){
            return arr[0];
        }

        while(low <= high){
            int mid = low + (high - low) / 2;


            if(mid > 0 && mid < arr.length-1 && arr[mid] != arr[mid-1] && arr[mid] != arr[mid+1]){
                return arr[mid];
            }

            if(mid == 0 && arr[mid] != arr[mid+1]){
                return arr[mid];
            }

            if(mid == arr.length-1 && arr[mid] != arr[mid-1]){
                return arr[mid];
            }

            // odd

            if(mid %2 != 0){
                if(arr[mid] == arr[mid+1] ){
                    high = mid -1;
                }else{
                    low = mid +1;
                }

                // even

            }else{
                if(arr[mid] == arr[mid+1] ){
                    low = mid +1;
                }else{
                    high = mid -1;
                }
            }

        }

        return -1;
    }
}
