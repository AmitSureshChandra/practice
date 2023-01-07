// https://leetcode.com/problems/gas-station/description/

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0, min = Integer.MAX_VALUE, minPos = -1, n = gas.length;
        for(int i=0; i< n; i++){
            int t = gas[i] - cost[i];

            // storing total
            total += t;

            // storing min value
            if(total < min){
                min = total;
                minPos = i;
            }
        }

        // if total is less than 0 then not possible
        if(total < 0) return -1;

        // start from next position of min value so that it can collect max gas
        return (minPos+1) % n;
    }
}
