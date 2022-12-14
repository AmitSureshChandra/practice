// https://leetcode.com/problems/validate-binary-search-tree/description/

class Solution {
    public boolean isValidBST(TreeNode root) {
        // solution 1 => inorder traversal 
        // TC : O(N)
        // SC : O(1)
        return inorder(root, new long[]{-2147483649l});
    }

    boolean inorder(TreeNode n, long[] arr){
        if(n == null) return true;
        if(!inorder(n.left, arr)) return false;
        if(arr[0] >= n.val) return false;
        arr[0] = n.val;
        if(!inorder(n.right, arr)) return false;
        return true;
    }
}
