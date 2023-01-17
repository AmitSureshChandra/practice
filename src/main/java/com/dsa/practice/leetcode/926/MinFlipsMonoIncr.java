// https://leetcode.com/problems/flip-string-to-monotone-increasing/description/

class Solution {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();

        // find first pos of 1 from start
        int pos = getFirstOnePos(s);
        if(pos == -1) return 0; // 1 not found => all monotonically sorted

        // count 1 from end
        int cnt1FromLast = cntOneFromLast(s);

        // then count 0's & 1's' after that 
        int ones = 0, zeros = 0;
        boolean startCounting = false;
        int ans = 0;
        for(int i=pos; i< s.length()-cnt1FromLast; i++){
            if(s.charAt(i) == '1') {
                startCounting = true;
                ones++;
                continue;
            }
            if(!startCounting) continue;
            zeros++;

            if(zeros > ones) {  // if zeroes are more than ones then reset & add count in ans
                startCounting = false;
                ans += ones;
                zeros = 0;
                ones = 0;
            }
        }

        return Math.min(ones, zeros) + ans;
    }

    int getFirstOnePos(String s){
        for(int i=0; i< s.length(); i++) if(s.charAt(i) == '1') return i;
        return -1;
    }

    int cntOneFromLast(String s){
        int cnt = 0;
        for(int i= s.length()-1; i >=0; i--){
            if(s.charAt(i) == '1') cnt++;
            else return cnt;
        }
        return cnt;
    }
}
