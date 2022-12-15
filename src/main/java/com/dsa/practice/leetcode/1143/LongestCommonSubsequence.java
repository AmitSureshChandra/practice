// https://leetcode.com/problems/longest-common-subsequence/

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();

        int[][] dp = new int[2][n2+1];

        for(int i=1; i<= n1; i++){
            char t1 = text1.charAt(i-1);
            for(int j=1; j<= n2; j++){
                char t2 = text2.charAt(j-1);
              
                // if both are matching then diagonally previuos + 1
                if(t1 == t2) dp[1][j] = dp[0][j-1]+1;
              
                // otherwise max of top or left
                else dp[1][j] = Math.max(dp[1][j-1], dp[0][j]);
            }
            int[] tmp = dp[0];
            dp[0] = dp[1];
            
            // System.out.println(Arrays.toString(tmp));
            dp[1] = tmp;
        }

        return dp[0][n2];
    }
}
