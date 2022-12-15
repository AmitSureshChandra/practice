// https://practice.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1

class Temp{
    public Node n;
    public int d;
    public Temp(Node node, int di) { n = node; d = di;}
}

class Solution
{
	ArrayList <Integer> boundary(Node node)
	{
	    ArrayList <Integer> ans = new ArrayList<>();
	    
	    // add all left node 
	    Node n = node;
	    
	    while(node.left != null && n != null && (n.left != null || n.right != null)){
	        ans.add(n.data);
	        if(n.left == null && n.right != null)
	            n = n.right;
	        else n = n.left;
	    }
	    
	    if(node.left == null) ans.add(node.data);
	    
	    // add all leaf node
	    if(node.left != null || node.right != null)
	    dfs(node, ans);
	    
	    // add all right node 
	    n = node.right;
	    ArrayList <Integer> rightNodes = new ArrayList<>();
	    while(n != null && (n.left != null || n.right != null)){
	        rightNodes.add(n.data);
	        if(n.right == null && n.left != null)
	            n = n.left;
	        else n = n.right;
	    }
	    
	    for(int i=rightNodes.size()-1; i>=0; i--) ans.add(rightNodes.get(i));
	    
	    return ans;
	}
	
	void dfs(Node n, ArrayList <Integer> ans){
	    if(n == null) return;
	    if(n.left == null && n.right == null)  ans.add(n.data);
	    dfs(n.left, ans);
	    dfs(n.right, ans);
	}
}
