package com.dsa.practice.two_ptr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class three_sum {

    public static void main(String[] args) {
        List<List<Integer>>  ans = new three_sum().threeSum(new int[]{0,0,0,0});
        for (List<Integer> i:
        ans){
            System.out.println(Arrays.toString(i.toArray()));
        }
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        outer:
        for(int i=0; i< nums.length-2; i++){

            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            int temp = - nums[i];
            int l = i+1;
            int r = nums.length-1;

            while(l < r){
                int sum = nums[l]+nums[r];

                if(sum == temp){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);

                    ans.add(list);

                    while (l < nums.length-1 && nums[l] == nums[l+1]){
                        l++;
                    }

                    while (r > 0 && nums[r] == nums[r-1]){
                        r--;
                    }
                }

                if(sum > temp){
                    r--;
                }else{
                    l++;
                }
            }
        }

        return ans;
    }
}
