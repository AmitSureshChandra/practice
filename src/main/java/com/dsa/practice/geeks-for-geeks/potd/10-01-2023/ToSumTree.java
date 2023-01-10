// https://practice.geeksforgeeks.org/problems/d7e0ce338b11f0be36877d9c35cc8dfad6636957/1


/*Complete the Given Function

Node is as follows:
class Node{
    int data;
    Node left,right;
    Node(int d){
    	data=d;
    	left=null;
    	right=null;
    }
}*/

class Solution{
    public void toSumTree(Node root){
        sum(root);
    }
    
    int sum(Node root){
        if(root == null) return 0;
        
        int t = root.data;
        
        // for leaf node
        if(root.left == null && root.right == null){
            root.data = 0;
            return t;
        }
        
        // accumulate from left & right
        int left = sum(root.left);
        int right = sum(root.right);
        
        root.data = left+ right;
        
        return root.data + t;
    }
}
