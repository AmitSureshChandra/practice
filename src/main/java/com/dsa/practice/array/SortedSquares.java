package com.dsa.practice.array;

import java.util.Arrays;

public class SortedSquares {

    public static void main(String[] args) {
        int[]arr = new int[]{-3,-1,0};
        System.out.println(Arrays.toString(new SortedSquares().sortedSquares(arr)));
    }

    public int[] sortedSquares(int[] nums) {

        if(nums.length == 1){
            return new int[]{nums[0] * nums[0]};
        }

        // find seperation point between +ve & -ve

        int pos = -1;

        for(int i=0; i< nums.length - 1; i++){
            if(nums[i] < 0 && nums[i+1] >= 0){
                pos = i+1;
                break;
            }
        }

        boolean all_pos = true;

        if(pos == -1 && nums[0] < 0){
            all_pos = false;
        }

        // do square of each


        if(all_pos && pos == -1){
            for(int i=0; i< nums.length; i++){
                nums[i] = nums[i] * nums[i];
            }

            return nums;
        }

        if(!all_pos && ( pos == -1)){
            for(int i=0; i< nums.length; i++){
                nums[i] = nums[i] * nums[i];
            }

            int left = 0;
            int right = nums.length- 1;

            while(left < right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                left++;
                right--;
            }

            return nums;
        }

        int i = pos-1, j = pos;

        int[] ar = new int[nums.length];
        int cnt = 0;

        while( i>= 0 || j < nums.length){

            if(i < 0){
                ar[cnt] = nums[j] * nums[j];
                j++;
                cnt++;
                continue;
            }

            if(j >= nums.length){
                ar[cnt] = nums[i] * nums[i];
                i--;
                cnt++;
                continue;
            }

            if((- nums[i]) < nums[j]){
                ar[cnt] = nums[i] * nums[i];
                i--;
            }else{
                ar[cnt] = nums[j] * nums[j];
                j++;
            }

            cnt++;

        }

        // merge both arrays


        return ar;
    }
}
