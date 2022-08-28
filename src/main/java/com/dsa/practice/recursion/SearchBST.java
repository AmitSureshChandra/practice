package com.dsa.practice.recursion;

/**
 * Definition for a binary tree node.

 */

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

public class SearchBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4,
                    new TreeNode(2,
                                new TreeNode(1),
                                new TreeNode(3)
                            ),
                    new TreeNode(7)
                );

        TreeNode node = root;
        while (node != null){
            System.out.println(node.val);
        }
    }
    public TreeNode searchBST(TreeNode root, int val) {

        TreeNode node = root;

        while(node != null){

            if(node.val == val){
                return node;
            }

            if(node.val < val){
                node = node.right;
            }else{
                node = node.left;
            }
        }

        return null;
    }
}
