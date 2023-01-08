// https://leetcode.com/problems/max-points-on-a-line/submissions/

class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if(n <= 2) return n;

        int ans = 0;
        for(int i=0; i< n; i++){

            // storing slope of points
            Map<Double, Integer> map = new HashMap<>();
            for(int j=i+1; j< n; j++){
                double slope = getSlope(points, i, j);
                map.put(slope, map.getOrDefault(slope, 0) + 1);
                // storing max length
                ans = Math.max(ans, map.get(slope));
            }
        }

        // adding one extra because we were not counting ith point in above loop
        return ans+1;
    }

    double getSlope(int[][] pts, int i, int j){
        if(pts[i][0] == pts[j][0]) return Double.POSITIVE_INFINITY;
        if(pts[i][1] == pts[j][1]) return 0;
        return (double)(pts[i][1] - pts[j][1]) / (double)(pts[i][0] - pts[j][0]);
    }
}
