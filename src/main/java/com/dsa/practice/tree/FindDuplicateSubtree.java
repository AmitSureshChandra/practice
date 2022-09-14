package com.dsa.practice.tree;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class FindDuplicateSubtree {

    public static class TreeNode {
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

    public static void main(String[] args) {

        TreeNode root = new TreeNode(
                1,
                new TreeNode(
                        2,
                        new TreeNode(
                                4,
                                null,
                                null
                        ),
                        null
                ),
                new TreeNode(
                        3,
                        new TreeNode(
                                2,
                                new TreeNode(
                                        4,
                                        null,
                                        null
                                ),
                                null
                        ),
                        new TreeNode(
                                4,
                                null,
                                null
                        )
                )
        );
//  [0,null, 0,null,  0,0,null_,0,0,null,0,null,0,0]
//        TreeNode treeNode = new TreeNode(
//                0,
//                null,
//                new TreeNode(
//                        0,
//                        null,
//                        new TreeNode(
//                                0,
//                                new TreeNode(
//                                        0,
//                                        new TreeNode(
//                                                0,
//
//
//                                        ),
//                                        null
//                                ),
//                                null
//                        )
//                )
//        )

//        TreeNode root = new TreeNode(
//                0,
//                new TreeNode(
//                        0,
//                        new TreeNode(
//                                0,
//                                null,
//                                null
//                        ),
//                        null
//                ),
//                new TreeNode(
//                        0,
//                        null,
//                        new TreeNode(
//                                0,
//                                null,
//                                new TreeNode(
//                                        0,
//                                        null,
//                                        null
//                                )
//                        )
//                )
//        );
//        [2,1,11,11,null,1]
//        TreeNode root = new TreeNode(
//                2,
//                new TreeNode(
//                        1,
//                        new TreeNode(
//                                11,
//                                null,
//                                null
//                        ),
//                        null
//                ),
//                new TreeNode(
//                        11,
//                        new TreeNode(
//                                1,
//                                null,
//                                null
//                        ),
//                        null
//                )
//        );

        List<TreeNode> list = findDuplicateSubtrees(root);

        for (TreeNode t :
                list) {
            List<String> l = new ArrayList<>();
            dfs(t,l);
            System.out.println(l);
        }
    }

    //[0,null,0,null,0,0,null,0,0,null,0,null,0,0]
    private static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> store = new HashMap<>();
        Set<TreeNode> ans = new HashSet<>();
        getDfs(root, store, ans);
        return new ArrayList<>(ans);
    }

    static String getDfs(TreeNode root, Map<String, Integer> store, Set<TreeNode> ans)     {
        // base case
        if(root == null){
            return "-";
        }

        // recur
        String current =  getDfs(root.left, store, ans) + "_"+ root.val +"_" +  getDfs(root.right, store, ans);

        store.put(current, store.getOrDefault(current, 0) + 1);
        if(store.get(current) == 2) {
            ans.add(root);
        }

        return current;
    }

    static void dfs(TreeNode node, List<String> list){

        if(node == null){
            return;
        }
        list.add(node.val+"");

        if(node.left != null){
            dfs(node.left, list);
        }

        if(node.right != null){
            dfs(node.right, list);
        }
    }
}
