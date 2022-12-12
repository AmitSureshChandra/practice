// https://leetcode.com/problems/balanced-binary-tree/description/

class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return height(root) == -1 ? false : true;
    } 
    
    int height(TreeNode root){
        if(root == null) return 0;
        int l = height(root.left);
        int r = height(root.right);

        // if any left or right node returns -1 then it means it is not balanaced
        if(l == -1 || r == -1) return -1;

        // return -1 if diff of height of left & right is greater than 1
        return Math.abs(r - l) > 1 ? -1 : Math.max(l, r)+1;
    }
}

// TC : O(n)
// SC : O(n)
