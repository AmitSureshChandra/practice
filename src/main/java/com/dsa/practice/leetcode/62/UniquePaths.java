// https://leetcode.com/problems/unique-paths/description/

// SC : O(N^2) to O(N)
// TC : O(N^2)
  
class Solution {
    public int uniquePaths(int m, int n) {
        // recursive
        // return cntPath(0,0, m, n, new int[m][n]);

        // iterative
      
        // we can optimize from SC : O(N^2) to O(N)
        int[][] dp = new int[m][n];
        Arrays.fill(dp[0], 1);

        for(int i=0; i< m; i++) dp[i][0] = 1;

        for(int i=1; i< m; i++){
            for(int j=1; j< n; j++){
              
                // taking sum of path from left & right
                dp[i][j] = dp[i-1][j] + dp[i][j-1]; 
            }
        }

        return dp[m-1][n-1];

    }
    
    // recursive  - can't optimize on space
    int cntPath(int x, int y, int m, int n, int[][] dp){
        if(x < 0 || x >= m || y < 0 || y>= n) return 0;
        if(x == m-1 && y == n-1) return 1;

        if(x < m-1 && dp[x+1][y] == 0) dp[x+1][y] = cntPath(x+1, y, m, n, dp);
        if(y < n-1 && dp[x][y+1] == 0) dp[x][y+1] = cntPath(x, y+1, m, n, dp);

        dp[x][y] = (x < m-1 ? dp[x+1][y] : 0) + (y< n-1 ? dp[x][y+1] : 0);
        return dp[x][y];
    }
}
