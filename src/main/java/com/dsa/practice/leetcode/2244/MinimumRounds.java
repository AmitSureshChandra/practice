// https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/description/

class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        
        // storing in map for freq
        for(int i: tasks) map.put(i, map.getOrDefault(i, 0) + 1);

        int ans = 0;
        for(int k: map.keySet()){
            int v = map.get(k);

            // if freq is less than 2
            if(v < 2) return -1;

            int t = v%3;

            // if directly mod of 3 & 2 
            if((t) % 2 == 0) 
                ans += (v/3) + (t)/2;
            else
                ans += (v/3) + 1; // if mod of 2 is not zero than it should be 1 so adding that 1 in 3 to make 2 + 2

            // above eqn is `ans += (v/3 -1) + 2` => `ans += (v/3 + 1)`
        }

        return ans;
    }
}
