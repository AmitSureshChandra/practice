//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/

class Solution {
    public TreeNode buildTree(int[] p, int[] i) {
        if(p.length == 1) return new TreeNode(p[0]);
        return constructTree(p, i, 0, p.length-1, 0, i.length-1);
    }

    int getRootPosInInorder(int[] i, int val){
        for(int k=0; k< i.length; k++){
            if(i[k] == val) return k;
        }
        return -1;
    }

    // p  - preorder
    // pi - preorder initial index
    // pe - preorder end index
    // i  - inorder
    // is - inorder initial index
    // ie - inorder end index
  
    TreeNode constructTree(int[] p, int[] i, int pi, int pe, int is, int ie){
        if(is > ie || pi > pe) return null;
        TreeNode root = new TreeNode(p[pi]);
        int rootPos = getRootPosInInorder(i, p[pi]);
        root.left = constructTree(p, i, pi+1, pe, is, rootPos-1);
        root.right = constructTree(p, i, pi+1 + rootPos - is, pe, rootPos+1, ie);
        return root;
    }
}
