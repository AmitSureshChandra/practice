package com.dsa.practice.binary_search;

import java.util.Arrays;

public class ValidTriangleNumber {

    public static void main(String[] args) {
        int[] nums = new int[]{4,2,3,4};
        System.out.println(new ValidTriangleNumber().triangleNumber(nums));
    }
    public int triangleNumber(int[] nums) {

        int n = nums.length -1;

        Arrays.sort(nums);

        int ans = 0;

        for(int i=n; i>=2;i--){
            for(int k=0, j=i-1; k<j;){
                if(nums[k] + nums[j] > nums[i]){
                    ans += (j-k);
                    j--;
                }else{
                    k++;
                }
            }
        }

        return ans;
    }
}
