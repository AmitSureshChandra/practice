// https://leetcode.com/problems/maximum-bags-with-full-capacity-of-rocks/description/

class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {

        // store diff
        for(int i=0; i< rocks.length; i++){
            capacity[i] -= rocks[i];
        }
        int cnt = 0, addRocks = additionalRocks;

        // sort so that min diff is processed first 
        Arrays.sort(capacity);

        for(int i=0; i< capacity.length && addRocks > 0; i++){

            // use addRocks untill left
            if(capacity[i] <= addRocks){
                addRocks -= capacity[i];
                cnt++;
            }else break; // break if addRocks is less than min of capacity diff
        }

        return cnt;
    }
}
