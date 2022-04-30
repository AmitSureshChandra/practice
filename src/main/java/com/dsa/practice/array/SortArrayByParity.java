package com.dsa.practice.array;

import java.util.Scanner;

/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/511/in-place-operations/3260/
 */

public class SortArrayByParity {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] ar = new int[] {2,4,1,3};

        new SortArrayByParity().sortArrayByParity(ar);

        for (int a : ar) {
            System.out.print(a);
        }
    }

    public int[] sortArrayByParity(int[] nums) {

        // ptr to get pos of odd no
        int ptr = -1;

        for(int i=0; i< nums.length; i++){

            // set ptr
            if((nums[i] & 1) != 0 && ptr == -1){
                ptr = i;
                continue;
            }

            // for skipping
            if((ptr == -1 && (nums[i] & 1) == 0) || (ptr != -1 && (nums[i] & 1) != 0)) {
                continue;
            }

            if(ptr == i) continue;

            if((nums[i] & 1) == 0 && ptr != -1){

                // for swapping
                swap(i, ptr, nums);

                // for calculating next odd pos
                while(ptr <= i){
                    if(nums[ptr] % 2 != 0){
                        break;
                    }
                    ptr++;
                }
            }
        }

        return nums;
    }

    private void swap(int i, int ptr1, int[] nums) {
        int temp = nums[ptr1];
        nums[ptr1] = nums[i];
        nums[i] = temp;
    }

}
