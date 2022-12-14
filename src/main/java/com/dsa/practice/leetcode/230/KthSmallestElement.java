// https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int[] ar = new int[2];
        inorder(root, k, ar);
        return ar[1];
    }

    void inorder(TreeNode root, int v, int[] ar){
        if(root == null) return;
        inorder(root.left, v, ar);
        ar[0]++;
        if(ar[0] == v){
            ar[1] = root.val;
        }
        inorder(root.right, v, ar);
    }
}
