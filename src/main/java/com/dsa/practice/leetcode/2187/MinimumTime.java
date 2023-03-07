// 


class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        int min = time[0];

        // calculate min
        for(int i: time) 
            min = Math.min(min, i);

        // setting r & l for binary search
        // searching lower time for which totalTrips is done
        long r = totalTrips * (long)min, l = 1l, ans = r;

        while(l <= r) {
            long mid = l + (r - l)/2;
            if(check(mid, time, totalTrips)) {
                ans = mid;
                r = mid - 1;
            }else l = mid + 1;
        }

        return ans;
    }

    // checking if given time we can do totalTrips
    boolean check(long t, int[] time, int totalTrips){
        long total = 0;
        for(int i: time) {
            total += t/i;
        }
        return total >= totalTrips;
    }
}
