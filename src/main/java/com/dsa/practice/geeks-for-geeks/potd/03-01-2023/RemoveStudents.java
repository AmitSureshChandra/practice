// https://practice.geeksforgeeks.org/problems/7d0fa4007b8eabadc404fcc9fa917aa52982aa96/1

class Solution {
    public int removeStudents(int[] h, int n) {
        int[] dp = new int[n];
        int len = 0;
        
        for(int i=0; i< n; i++){
          
            // binary search that number
            int p = Arrays.binarySearch(dp, 0, len, h[i]);
            
            if(p < 0) {
                p = -(p+1);
            }
            
            dp[p] = h[i];
            
            // if pos is greater than length then increment length
            if(p == len) {
                len++;
            }
        }
        
        return n - len;
    }
}
