package com.dsa.practice.array;

import java.util.ArrayList;
import java.util.List;

public class FindNumeberDisappeared {

    public static void main(String[] args) {
        int[]arr = new int[]{4,3,2,7,8,2,3,1};
        System.out.println(new FindNumeberDisappeared().findDisappearedNumbers(arr));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i=0; i< nums.length; i++){

            if(nums[Math.abs(nums[i]) - 1] > 0){
                nums[Math.abs(nums[i]) - 1] = - nums[Math.abs(nums[i]) - 1];
            }
        }

        List<Integer> list = new ArrayList<>();

        for(int i=0; i< nums.length; i++){
            if(nums[i] > 0){
                list.add(i+1);
            }
        }

        return list;
    }
}
