// https://leetcode.com/problems/decode-ways/

class DecodeWays {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0'){
            return 0;
        }
        
        int a = 1;                          // dp[i-2]
        int b = s.charAt(0) == '0' ? 0 : 1; // dp[i-1]
        int ans = b;
        
        for(int i=2; i<= s.length(); i++){ 
            
            ans = 0;
            
            int current = Integer.parseInt(Character.toString(s.charAt(i-1)));
            int lastTwo =  Integer.parseInt(Character.toString(s.charAt(i-2))) * 10 + current;

            // if last term is 1 to 9 then dp[i-1] ways 
            if(current >= 1 && current <= 9){
                ans = b;
            }
            
            // if last 2 term is 10 to 26 then dp[i-2] ways 
            if(lastTwo >= 10 && lastTwo <= 26){
                ans += a;
            }
            
            a = b;
            b = ans;
        }
        
        return ans;  
    }
}
