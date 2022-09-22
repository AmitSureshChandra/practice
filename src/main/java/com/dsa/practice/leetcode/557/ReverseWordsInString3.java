// https://leetcode.com/problems/reverse-words-in-a-string-iii/

class Solution {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        
        boolean first = true;
        String[] arr = s.split(" ");
        
        for(int t=0; t< arr.length; t++){
            
            if(t > 0){
                ans.append(" ");
            }
            
            for(int i= arr[t].length()-1; i>=0; i--){
                ans.append(arr[t].charAt(i));
            }   
        }
        
        return ans.toString();
    }
}
