// https://leetcode.com/problems/non-decreasing-subsequences/description/

class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();
        for(int i=0; i< n; i++){

            int size = set.size();
            List<List<Integer>> plist = new ArrayList<>();

            // add current number in all past list if it greater or equals with last elemnt
            for(List<Integer> l: set){
                List<Integer> s = new ArrayList<>(l);
                if(nums[i] >= l.get(l.size()-1)){
                    s.add(nums[i]);
                    plist.add(s);
                }
            }
            // adding self number as list
            List<Integer> another = new ArrayList<>();
            another.add(nums[i]);
            plist.add(another);
            for(List<Integer> l: plist) set.add(l);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(List<Integer> l: set) if(l.size() > 1) ans.add(l);
        return ans;
    }
}
