// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/

// TC : O(nlogn)
// SC : O(1) if not modifying initial array then O(n)

class Solution {
    public int findMinArrowShots(int[][] points) {

        // sort based on end
        Arrays.sort(points, (t1, t2) -> {
            if(t1[1] == t2[1]) return Integer.compare(t1[0], t2[0]);
            return Integer.compare(t1[1], t2[1]);
        });

        int i = 0, cnt = 0;
        while(i < points.length){
            if(i == points.length-1) return cnt+1;
            int[] t = points[i++];

            // check untill next ballons have start less than end, burst them with single arrow
            while(i < points.length && points[i][0] <= t[1]) {
                if(i == points.length-1) return cnt+1;
                i++;
            }
            cnt++;
        }
        return cnt;
    }
}
