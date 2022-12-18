// https://leetcode.com/problems/daily-temperatures/description/

class Solution {
    public int[] dailyTemperatures(int[] t) {
        int n = t.length;
        int[] ans = new int[n];
        Deque<Integer> dq = new LinkedList<>();

        for(int i=0; i< n; i++){
            // till start element is less than current 
            while(!dq.isEmpty() && t[dq.getFirst()] < t[i]){
                ans[dq.getFirst()] = i - dq.removeFirst();
            }

            // till last element is less than current 
            while(!dq.isEmpty() && t[dq.getLast()] < t[i]){
                ans[dq.getLast()] = i - dq.removeLast();
            }

            // add in dequeu
            dq.addLast(i);
        }
        return ans;
    }
}
