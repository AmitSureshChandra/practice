// https://leetcode.com/problems/insert-interval/description/

// TC : O(N)
// SC : O(N)

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        if(n == 0) return new int[][]{newInterval};
        
        // pos denotes start point of merge
        int pos = bs(intervals, newInterval, 0, n-1);

        // i denotes where merge will end (exclusive)
        int i= pos;
        while(i< n && intervals[i][0] <= newInterval[1]) i++;

        int size = n; // size will range from 1 to n+1
        if(i > 0) size = n - (i-pos-1);
        else if(intervals[0][0] > newInterval[1] || intervals[n-1][1] < newInterval[0]) size = n+1;
        if(intervals[0][0] > newInterval[0] && intervals[n-1][1] < newInterval[1]) size = 1;

        int[][] ans = new int[size][2];

        // copy till pos-1
        for(int j=0; j< pos; j++) ans[j] = intervals[j];

        if(i == 0 && pos == 0 || pos == n) ans[pos] = newInterval; 
        else if(i > 0 && pos < n){
            // merge from pos to i-1
            ans[pos][0] = Math.min(newInterval[0], intervals[pos][0]);
            ans[pos][1] = Math.max(newInterval[1], intervals[i-1][1]);
        }
       
        // copy from i to n
        while(i< n && pos+1< ans.length) ans[++pos] = intervals[i++];
        return ans;
    }

    int bs(int[][] intervals, int[] newInterval, int l, int r){
        int pos = intervals.length;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(intervals[mid][1] >= newInterval[0]) {
                r = mid-1;
                pos = Math.min(mid, pos);
            }else{
                l = mid + 1;
            }
        }
        return pos;
    }
}
