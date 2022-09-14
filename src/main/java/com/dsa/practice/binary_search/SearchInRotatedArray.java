package com.dsa.practice.binary_search;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchInRotatedArray {

    public static void main(String[] args) {
        assertEquals(1,new SearchInRotatedArray().search(new int[]{8,9,2,3,4}, 9));
        assertEquals(0,new SearchInRotatedArray().search(new int[]{8,9,2,3,4}, 8));
        assertEquals(4,new SearchInRotatedArray().search(new int[]{8,9,2,3,4}, 4));
        assertEquals(-1,new SearchInRotatedArray().search(new int[]{8,9,2,3,4}, 5));
        assertEquals(1,new SearchInRotatedArray().search(new int[]{1,2}, 2));
        assertEquals(0,new SearchInRotatedArray().search(new int[]{1,2}, 1));
        assertEquals(1,new SearchInRotatedArray().search(new int[]{2,1}, 1));
        assertEquals(0,new SearchInRotatedArray().search(new int[]{2,1}, 2));
        assertEquals(2,new SearchInRotatedArray().search(new int[]{1,2,3}, 3));
    }

    public int search(int[] nums, int target) {

        if(nums.length == 1){
            if(nums[0] == target){
                return 0;
            }else
                return -1;
        }

        int n = nums.length - 1;

        int low = 0;
        int high = n;

        int rp = -1;

        while(low < high){

            int mid = low + (high - low)/2;

//            System.out.println("mid : " +mid );

            if((mid == 0 && nums[mid] > nums[mid + 1]) || (mid == n && nums[mid] > nums[mid - 1])){
                rp = mid;
            }

            if(mid > 0 && mid < n && nums[mid] > nums[mid+1] && nums[mid] > nums[mid-1]){
                rp = mid;
            }

            if(nums[mid] > nums[high]){
                low = mid + 1;
            }else{
                high = mid;
            }
        }

//        System.out.println("rp : " + rp);

        if(rp == -1){
            return  bs(nums, target, 0, n);
        }

        if(target < nums[0]){
            return bs(nums, target, rp+1, n);
        }else{
            return bs(nums, target,0 , rp);
        }

    }

    int bs(int[] nums, int target, int low, int high){

        while(low <= high){

            int mid = low + (high - low)/2;

//            System.out.println("mid : " + mid);

            if(nums[mid] == target){
                return mid;
            }

            if(nums[mid] > target){
                high = mid -1;
            }else{
                low = mid + 1;
            }
        }

        return -1;
    }
}
