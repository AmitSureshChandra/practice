// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/


class Solution {
    TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    boolean dfs(TreeNode root, TreeNode p, TreeNode q){
        if(ans != null) return true;
        if(root == null) return false;
      
        // checks in left
        int l = dfs(root.left, p, q) ? 1: 0;
      
        // checks in right
        int r = dfs(root.right, p, q) ? 1: 0;
      
        // check if current is one of the node
        int c = root.val == p.val || root.val == q.val ? 1: 0;
      
        // if any two of above is true then both nodes are found & store current node in ans
        if(ans == null && (l + r + c) >= 2) ans = root;
      
        // returning parent that atleats one node exists in current subtree
        return (l + r + c) >= 1;
    }
}
