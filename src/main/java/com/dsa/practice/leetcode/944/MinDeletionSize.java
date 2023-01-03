// https://leetcode.com/problems/delete-columns-to-make-sorted/description/

class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;

        if(n == 1) return 0;

        int cnt = 0;
        for(int i=0; i< strs[0].length(); i++){
            for(int j=1; j < n; j++)
              // count & break if not in ascending 
                if(strs[j-1].charAt(i) > strs[j].charAt(i)) {
                    cnt++;
                    break;
                }
        }
        return cnt;
    }
}
