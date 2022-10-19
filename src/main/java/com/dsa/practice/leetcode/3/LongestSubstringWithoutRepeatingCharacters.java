// https://leetcode.com/problems/longest-substring-without-repeating-characters/

class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0, cnt = 0;
        // store last index in map 
        // maintain l to point start of non-repeating character word
        for(int i=0, l=0; i< s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                // some repeating letter pos is lesser than l so avoid it but update it in map
                if(l < map.get(s.charAt(i)) + 1) l = map.get(s.charAt(i)) + 1;
                map.put(s.charAt(i), i);
            }else map.put(s.charAt(i), i);
            cnt = i-l+1;
            max = Math.max(cnt, max);
        }
        return max;
    }
}
