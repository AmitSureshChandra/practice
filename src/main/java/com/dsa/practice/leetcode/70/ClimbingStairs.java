/**
* https://leetcode.com/problems/climbing-stairs/
*/


class ClimbingStairs {
    int ans = 0;
    public int climbStairs(int n) {
        
        // recursive
        // return solveRecursive(n, new Integer[n+1]);
        
        // iterative
        return solveIterative(n);
    }
    
    int solveIterative(int n){
        
        // similar to fibonnaci
        
        if(n == 1 || n == 0)  return 1;
        int j1 = 1, j2 = 1, ans = 0;
        for(int i=2; i<= n; i++){
            ans = j1 + j2;
            j1 = j2;
            j2 = ans;
        }
        
        return ans;
    }
    
    int solveRecursive(int n, Integer[] dp){
        
        // base case 
        
        if(n < 0) return 0;
        if(n == 0 || n == 1) return 1;
        
        // recursion 
        
        if(dp[n-1] == null) dp[n-1] = solveRecursive(n-1, dp);
        if(dp[n-2] == null) dp[n-2] = solveRecursive(n-2, dp);
        dp[n] = dp[n-1] + dp[n-2];
        return dp[n];
    }
}
