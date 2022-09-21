// https://leetcode.com/problems/sum-of-even-numbers-after-queries/

class SumOfEvenNumbersAfterQueries {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] ans = new int[queries.length];
        int cnt = 0;
        
        int evenSum = 0;
        
        // calculating sum of even numbers
        for(int i: nums){
            evenSum += ( isEven(i) ? i : 0);
        }
        
        for(int[] q: queries){
            if(q[1] >= nums.length){
                continue;
            }
            
            // first removing old even from sum
            if(isEven(nums[q[1]])){
                evenSum -= nums[q[1]];
            }
          
            // updating based on query
                                
            nums[q[1]] = nums[q[1]] + q[0];
            
            // adding in sum if even 
            if(isEven(nums[q[1]])){
                evenSum += nums[q[1]];
            }
                                
            ans[cnt++] = evenSum;
        }
                                
        return ans;
        
    }
    r
    boolean isEven(int i){
        return (i & 1) == 0;
    }
}
