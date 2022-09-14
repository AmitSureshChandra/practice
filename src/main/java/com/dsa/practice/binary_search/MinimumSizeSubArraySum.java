package com.dsa.practice.binary_search;

public class MinimumSizeSubArraySum {

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,1,1,1,1,1};
        System.out.println(new MinimumSizeSubArraySum().minSubArrayLen(11, arr));
    }
    public int minSubArrayLen(int target, int[] nums) {
        int low = 1;

        int high = nums.length;

        int ans = Integer.MAX_VALUE;

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isValid(mid, nums, target)){
                ans = Math.min(ans, mid);
                high = mid -1;
            }else{
                low = mid + 1;
            }
        }

        if(ans == Integer.MAX_VALUE){
            return 0;
        }

        return ans;
    }

    boolean isValid(int n, int[] nums, int target){
        int sum = 0;
        for(int i=0; i< n; i++){
            sum += nums[i];
        }

        if(sum >= target){
            return true;
        }

        for(int i=n; i< nums.length; i++){
            sum += (nums[i] - nums[i-n]);

            if(sum >= target){
                return true;
            }
        }

        return false;
    }
}
