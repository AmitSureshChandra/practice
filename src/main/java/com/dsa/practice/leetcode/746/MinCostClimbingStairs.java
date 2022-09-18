// https://leetcode.com/problems/min-cost-climbing-stairs/

class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        // return minCostRecursive(cost.length, new Integer[cost.length+1], cost);
        return minCostIterative(cost.length, cost);
    }
    
    int minCostIterative(int n, int[] cost){
        int n_1 = 0, n_2 = 0, ans = 0;
        for(int i=2; i<= n; i++){
            ans = Math.min(n_1 + cost[i-1], n_2 + cost[i-2]);
            n_2 = n_1;
            n_1 = ans;
        }
        return ans;
    }
    
    int minCostRecursive(int n, Integer[] dp, int[] cost){
        
        
        // recurrance relation
        
        // f(n) = min(f(n-1)+(n-1) , f(n-2) + (n-2));
        
        // base case
        
        if(n == 0 || n == 1) return 0;
        
        if(dp[n] != null) return dp[n];
        
        return dp[n] = Math.min(minCostRecursive(n-1, dp, cost) + cost[n-1], minCostRecursive(n-2, dp, cost) + cost[n-2]);
    }
    
    
}
