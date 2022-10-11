// https://leetcode.com/problems/increasing-triplet-subsequence/

class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE;
        int middle = Integer.MAX_VALUE;
      
        // maintain min & middle value, if any value greater that min & middle then it is ans
      
        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= min){
                min = nums[i];
            }else if(nums[i] <= middle){ 
                middle = nums[i];
            }else return true;
        }
        return false;
    }
}
