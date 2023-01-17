// https://leetcode.com/problems/insert-interval/description/

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> l = new ArrayList<>();
        int n = intervals.length;
        int[] merge = new int[2]; // to store temperory merge array
        boolean mergeStarted = false; // indicated whether merge going on
        boolean merged = false; // indicates whether merged
        for(int i=0; i< n; i++){
            if(merged) l.add(intervals[i]);  // add pending arrays
            else if(mergeStarted) {         
                if(intervals[i][0] <= merge[1]) {       // it is mergable so merge it   
                    merge[1] = Math.max(merge[1], intervals[i][1]);
                }else{                                  
                    l.add(merge);
                    l.add(intervals[i]);
                    merged = true;
                    mergeStarted = false;
                }
            }
            else if(intervals[i][0] > newInterval[1]) {l.add(newInterval); l.add(intervals[i]); merged = true;}
            else if(intervals[i][1] < newInterval[0]) l.add(intervals[i]);
            else {
                merge[0] = Math.min(intervals[i][0], newInterval[0]);
                merge[1] = Math.max(intervals[i][1], newInterval[1]);
                mergeStarted = true;        // starting merge here
            }
        }
        if(mergeStarted) {l.add(merge); merged = true;} // if merge array is pending to add in list
        if(!merged) l.add(newInterval); // if newInterval is out of max then 

        int[][] ans = new int[l.isEmpty() ? 1 : l.size()][2];

        for(int i=0; i< l.size(); i++) ans[i] = l.get(i);
        if(n == 0) ans[0] = newInterval;
        return ans;
    }
}
