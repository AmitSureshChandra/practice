// https://leetcode.com/problems/binary-tree-preorder-traversal/description/

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
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return  new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        List<Integer> l= new ArrayList<>();

        // adding root node
        s.push(root);

        while(!s.isEmpty()){
            // take node from stack & process
            TreeNode n = s.pop();
            if(n == null) continue;
            l.add(n.val);

            // adding right & left node => it is stack so add first right for preorder
            if(n.right != null) s.push(n.right);
            if(n.left != null) s.push(n.left);
        }

        return l;
    }
}
