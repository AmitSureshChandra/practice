package com.dsa.practice.array;

/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/511/in-place-operations/3575/
 */
public class RemoveElement {

    public static void main(String[] args) {

        int[]arr = new int[]{
               1,1,1
        };
        System.out.println(new RemoveElement().removeElement(arr, 1));

        for(int i: arr){
            System.out.print( i);
        }
    }

    public int removeElement(int[] nums, int val) {
        int ptr = -1;
        int cnt = 0;

        for(int i=0; i< nums.length; i++){
            if(ptr == -1 && nums[i] == val){
                ptr = i;
                cnt++;
                continue;
            }

            if(nums[i] == val){
                cnt++;
            }

            if ((nums[i] == val && ptr != -1 ) || (nums[i] != val && ptr == -1)){
                continue;
            }

            if(nums[i] != val && ptr != -1){
                swap(i, ptr, nums);
                while(ptr <= i){
                    if(nums[ptr] == val){
                        break;
                    }
                    ptr++;
                }
            }
        }
        return nums.length - cnt;
    }

    private void swap(int i, int ptr1, int[] nums) {
        int temp = nums[ptr1];
        nums[ptr1] = nums[i];
        nums[i] = temp;
    }
}
