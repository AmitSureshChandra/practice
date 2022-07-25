package com.dsa.practice.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array
 */
public class RemoveDuplicatedFromSortedArray {

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicatedFromSortedArray().removeDuplicates(new int[]{0,0,1,1,1,2,2}));
    }
    public int removeDuplicates(int[] nums) {

        int j = 1;

        for(int i=1; i< nums.length; i++){
            if(nums[i] != nums[i-1]){
                nums[j++] = nums[i];
            }
        }

        return j;
    }
}
