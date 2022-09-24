// https://leetcode.com/problems/path-sum-ii/

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        solve(root, 0, targetSum, ans, l);
        return ans;
    }
    
    void solve(TreeNode n, int s, int t, List<List<Integer>> ans, List<Integer> l){
        if(n == null){
            return;
        }
        l.add(n.val);
        if(n.left == null && n.right == null && s == t - n.val){
            ans.add(new ArrayList<>(l));
        }else{
            solve(n.left, s + n.val, t,ans, l);
            solve(n.right, s + n.val, t,ans, l);
        }
        l.remove(l.size()-1);
    }
}
