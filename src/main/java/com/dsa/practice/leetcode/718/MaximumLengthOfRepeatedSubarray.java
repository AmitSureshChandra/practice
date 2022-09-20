// https://leetcode.com/problems/maximum-length-of-repeated-subarray/

class MaximumLengthOfRepeatedSubarray {
    public int findLength(int[] nums1, int[] nums2) {
        
        int maxlength = Math.max(nums2.length, nums1.length);
        
        int[] dp_ = new int[nums2.length];
        int[] dp = new int[nums2.length];
        
        int max = 0;
        
        for(int i=0; i< nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                if(nums1[i] == nums2[j]){
                    if(i > 0 && j > 0){
                        dp[j] += dp_[j-1] + 1;    
                    }else{
                        dp[j]= 1;
                    }
                    
                    max = Math.max(max, dp[j]);
                }
            }
            
            dp_ = dp;
            dp = new int[nums2.length];
        }
        
        return max;
    }
}
