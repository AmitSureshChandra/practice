// https://leetcode.com/problems/sum-root-to-leaf-numbers/description/


class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null) return sum;
        dfs(root, 0);
        return sum;
    }

    void dfs(TreeNode node, int v){
        // v hold value at current node
        v = v * 10 + node.val;
        if(node.left == null && node.right == null) {
            sum += v;
            return;
        }
        if(node.left != null) dfs(node.left, v);
        if(node.right != null) dfs(node.right, v);
    }
}
