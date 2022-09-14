package com.dsa.practice.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 */
public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TwoSum().twoSum(new int[]{3,2,4}, 6)));
    }
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i< nums.length; i++){
            map.put(nums[i], i);
        }

        for(int i=0; i< nums.length; i++){
            int temp = target - nums[i];

            if(temp == nums[i]){
                continue;
            }

            if(map.containsKey(temp)){
                if(i < map.get(target- nums[i]))
                    return new int[]{i, map.get(temp)};
                else
                    return new int[]{map.get(temp), i};
            }
        }

        return null;
    }
}
