// https://leetcode.com/problems/house-robber/

class Solution {
    public int rob(int[] nums) {
        // f(n) = max(f(n-1),  f(n-2) + a[n]);
        
        // recursive
        // return robRec(nums.length-1, nums, new Integer[nums.length+1]);
        
        // iterative 
        return robIterative(nums.length, nums);
    }
    
    int robIterative(int n, int[] nums){
        if(n == 1){
            return nums[0];
        }
        
        if(n == 2){
            return Math.max(nums[0], nums[1]);
        }
        
        int n_2 = nums[0];
        int n_1 = Math.max(nums[0], nums[1]);
        int ans = 0;
        
        for(int i=2; i< n; i++){
            ans = Math.max(n_2+ nums[i], n_1);
            n_2 = n_1;
            n_1 = ans;
        }
        
        return ans;
    }
    
    int robRec(int n, int[] nums, Integer[] dp){
        // base case 
        
        if(n == 0){ 
            return nums[n];
        }
        
        if(n == 1){
            return Math.max(nums[0], nums[1]);
        }
        
        if(dp[n-1] == null){
            dp[n-1] = robRec(n-1, nums, dp);
        }
        
        if(dp[n-2] == null){
            dp[n-2] = robRec(n-2, nums, dp);
        }
        
        return Math.max( dp[n-1], dp[n-2] + nums[n]); 
    }
}
