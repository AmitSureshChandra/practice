// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/

class Temp{
    public TreeNode start;
    public TreeNode end;

    public Temp(TreeNode s, TreeNode e){start = s; end = e;}
}
class Solution {

    public void flatten(TreeNode root) {
        postOrder(root);
    }

    Temp postOrder(TreeNode node){

        // return if leaf or null node
        if(node == null || node.left == null && node.right == null) return new Temp(node,  node);

        // get start & end of both side
        Temp left = postOrder(node.left);
        Temp right = postOrder(node.right);

        if(left.start != null){
            node.right = left.start;
            left.end.right = right.start;
        }   
        else node.right = right.start;
            
        node.left = null;
        return new Temp(node,  right.start != null ? right.end : left.end);
    }
}
