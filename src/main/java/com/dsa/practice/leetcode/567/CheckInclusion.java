// https://leetcode.com/problems/permutation-in-string/description/

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int[] ar1 = new int[26];
        int l1 = s1.length(), l2 = s2.length();

        // store char freq of s1
        for(int i=0; i< l1; i++){
            ar1[s1.charAt(i) - 'a']++;
        }

        // store freq of first l1 element of window of string s2
        int[] t = new int[26];
        for(int j=0; j< l1; j++) t[s2.charAt(j) - 'a']++;

        // check if both freq matches
        if(check(t, ar1)) return true;

        for(int i=1; i<= l2-l1; i++){

            // remove first entry of freq
            t[s2.charAt(i-1) - 'a']--;

            // add last entry of freq
            t[s2.charAt(l1 + i-1) - 'a']++;
            if(check(t, ar1)) return true;
        }

        return false;
    }

    boolean check(int[] t, int[] t2){
        for(int i=0; i< 26; i++){
            if(t[i] != t2[i]) return false;
        }
        return true;
    }
}
