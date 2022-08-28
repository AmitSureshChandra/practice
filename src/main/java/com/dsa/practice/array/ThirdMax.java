package com.dsa.practice.array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/523/conclusion/3231/
 */
public class ThirdMax {

    public static void main(String[] args) {
//        int[] arr = new int[]{1,2,-2147483648};
        int[] arr = new int[]{2,2,3,1};

        System.out.println(new ThirdMax().thirdMax(arr));
    }

    public int thirdMax(int[] nums) {
        int m1 = Integer.MIN_VALUE;
        int m2 = Integer.MIN_VALUE;
        int m3 = Integer.MIN_VALUE;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i< nums.length; i++){

            // for handling repeat digits
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 1);
            }else {
                // will continue if digits repeats
                continue;
            }

            if(nums[i] > m1){
                m3 = m2;
                m2 = m1;
                m1 = nums[i];
            }

            else if(nums[i] > m2){
                m3 = m2;
                m2 = nums[i];
            }

            else if(nums[i] > m3){
                m3 = nums[i];
            }else{
                //
            }
        }

        return map.size() < 3 ? m1: m3;
    }
}
