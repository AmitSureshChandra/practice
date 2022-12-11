
// https://leetcode.com/problems/binary-tree-maximum-path-sum/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        postOrder(root);
        return ans;
    }
    
    int postOrder(TreeNode node){
        if(node == null)  return 0;
        int l = Math.max(0, postOrder(node.left));
        int r = Math.max(0, postOrder(node.right));

        // calculate max from left, right & current
        ans = Math.max(ans, node.val + l + r);

        //returning max sum of left or right sub tree with current node value
        return Math.max(0, node.val + Math.max(l,r));
    }
}
