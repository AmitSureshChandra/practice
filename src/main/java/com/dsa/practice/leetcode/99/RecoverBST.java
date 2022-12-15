// https://leetcode.com/problems/recover-binary-search-tree/description/

class Temp{
    public TreeNode first;
    public TreeNode last;
    public TreeNode prev;
    boolean isFirstError = false;

    public Temp(TreeNode f, TreeNode l, TreeNode v){
        this.first = f;
        this.last = l;
        this.prev = v;
    }
}

class Solution {
    Temp t = new Temp(null, null, null);
  
    // using inorder to traverse sorted & detecting two decreasing point
    public void recoverTree(TreeNode root) {
        inorder(root);
        // if no second error detected then take next of first error element
        if(t.isFirstError) swap(t.first, t.last);
    }

    void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        if(t.prev != null && t.prev.val > root.val){
            if(t.isFirstError){
                // on second found
                t.last = root;
                swap(t.first, t.last);
                t.isFirstError = false;
            }else{
                // first wrong found
                t.first = t.prev;
                t.last = root;
                t.isFirstError = true;
            }
        }
        t.prev = root;
        inorder(root.right);
    }

    void swap(TreeNode f, TreeNode l){
        int tmp = l.val;
        l.val = f.val;
        f.val = tmp;
    }
}
