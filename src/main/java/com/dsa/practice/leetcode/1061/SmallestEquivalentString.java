// https://leetcode.com/problems/lexicographically-smallest-equivalent-string/description/

class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int s = s1.length();
        char[] ar = new char[26];

        for(int i=0; i< 26; i++){
            ar[i] = (char)('a' + i);
        }

        for(int i=0; i< s; i++){
            char c1 = getEquiv(ar, s1.charAt(i));
            char c2 = getEquiv(ar, s2.charAt(i));

            if(c1 < c2){
                ar[s2.charAt(i) - 'a'] = c1;
                ar[c2 - 'a'] = c1;
            }else{
                ar[s1.charAt(i) - 'a'] = c2;
                ar[c1 - 'a'] = c2;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i< baseStr.length(); i++){
            sb.append(getEquiv(ar, baseStr.charAt(i)));
        }
        return sb.toString();
    }

    char getEquiv(char[] ar, char c){
        if(ar[c - 'a'] == c) return c;
        return getEquiv(ar, ar[c - 'a']);
    }
}
