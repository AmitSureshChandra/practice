package com.dsa.practice.array;


import java.util.ArrayList;

/**
 * https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1/?page=1&difficulty[]=0&category[]=Arrays&sortBy=submissions
 */
public class SubarrayGivenSum {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{2,3,4,5,6,7},7, 15));
    }

    static ArrayList<Integer> subarraySum(int[] arr, int n, int s)
    {
        int sum = 0;
        int start_pos = 0;

        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0; i< arr.length; i++){

            sum += arr[i];

            if(checkSum(sum, s, ans, start_pos, i)){
                return ans;
            }

            if(sum < s){
                continue;
            }

            while(sum > s)
            {
                sum -= arr[start_pos];
                start_pos++;
                if(checkSum(sum, s, ans, start_pos, i)){
                    return ans;
                }
            }
        }

        ans.add(-1);

        return ans;
    }

    static boolean checkSum(int sum, int s, ArrayList<Integer> ans,int start_pos, int i){
        if(sum == s){
            ans.add(start_pos+1);
            ans.add(i+1);
            return true;
        }
        return false;
    }
}
