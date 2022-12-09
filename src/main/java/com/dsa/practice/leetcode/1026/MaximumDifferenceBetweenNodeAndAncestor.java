// https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/description/

class Solution {
    public int maxAncestorDiff(TreeNode root) {
        return maxDiff(root, root.val, root.val);
    }

    int maxDiff(TreeNode root, int min, int max){
        if(root == null) return -1;
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);

        // get max from left 
        int left = maxDiff(root.left, min, max);

        // get max from right
        int right = maxDiff(root.right, min, max);

        // cal max from left, right & current
        return Math.max(left, Math.max(right, Math.abs(max - min)));
    }
}
