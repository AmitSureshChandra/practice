// https://leetcode.com/problems/unique-paths-ii/description/

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) return 0;

        // we can optimize space from O(N^2) to O(N)
        int[][] dp = new int[m][n];
        
        for(int i=0; i< m; i++){
            for(int j=0; j< n; j++){

                // if obstacle then no path
                if(obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }

                // fill first column & row
                if(i == 0 || j == 0) {
                    
                    if(i == 0 && j == 0) dp[i][j] = 1;

                    // check that prev row or column should not be blocked
                    else if(i == 0 && dp[0][j-1] == 1 || j == 0 && dp[i-1][j] == 1)
                        dp[i][j] = 1;
                    continue; 
                }

                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];

    }
}
