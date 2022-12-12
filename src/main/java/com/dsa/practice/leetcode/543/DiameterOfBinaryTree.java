// https://leetcode.com/problems/diameter-of-binary-tree/description/

class Solution {
    int max = -1;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }

    int dfs(TreeNode node){
        if(node == null) return 0;
        int l = dfs(node.left);
        int r = dfs(node.right);
      
        // storing max length between nodes
        max =  Math.max(max, l+r);
        
        // returning height of each node
        return Math.max(l, r) + 1;
    }
}

// TC : O(n)
// SC : O(n)
