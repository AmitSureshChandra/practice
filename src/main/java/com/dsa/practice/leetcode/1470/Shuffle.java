// https://leetcode.com/problems/shuffle-the-array/submissions/

class Solution {
    public int[] shuffle(int[] nums, int n) {
        for(int i=1; i<= 2 * n; i++) {
            if((i & 1) == 0) nums[i-1] += (nums[i / 2 + n - 1] % 1001) * 1001;
            else nums[i-1] += (nums[(int)Math.ceil(((float)i/2)) - 1] % 1001) * 1001;
        }
        for(int i=0; i< 2 * n; i++) nums[i] = nums[i]/ 1001;
        return nums;
    }
}
