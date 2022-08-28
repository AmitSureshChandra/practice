package com.dsa.practice.array;

import java.util.HashMap;
import java.util.Map;

public class LargestSubArrayZeroSum {

    public static void main(String[] args) {
        int[] arr = new int[]{15,-2,2,-8,1,7,10,23};
        System.out.println(new LargestSubArrayZeroSum().maxLen(arr , arr.length));
    }

    int maxLen(int arr[], int n)
    {
        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;

        int len = 0;

        for(int i=0; i< arr.length; i++){

            sum += arr[i];

            if(sum == 0){
                len = Math.max(len, i+1);
                continue;
            }

            if(map.containsKey(sum)){
                len = Math.max(len, i - map.get(sum) -1);
                continue;
            }

            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
            System.out.println("len : " + len);
        }

        return len;

    }
}
