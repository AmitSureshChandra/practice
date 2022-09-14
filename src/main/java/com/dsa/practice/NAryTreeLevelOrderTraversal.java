package com.dsa.practice;


import java.util.ArrayList;
import java.util.List;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};


/**
 * https://leetcode.com/problems/n-ary-tree-level-order-traversal/
 */
public class NAryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        List<List<Integer>> ans = new NAryTreeLevelOrderTraversal().levelOrder(new Node(
                1, new ArrayList<Node>(){{
                    add(new Node(3,
                        new ArrayList<Node>(){{
                                add( new Node(5, null));
                                add( new Node(6, null));
                        }}
                    ));
                    add(new Node(2,null));
                    add(new Node(4,null));
                }}
        ));

        print(ans);
    }

    static void print(List<List<Integer>> ans){
        System.out.println("~~~~~~~");
        for (List<Integer> al :
                ans) {
            System.out.println(al);
        }
        System.out.println("~~~~~~~");
    }
    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> ans = new ArrayList<>();
        ans.add( new ArrayList<>());
        ans.get(0).add(root.val);
        traverse(root, ans, 1);
        return ans;
    }

    void traverse(Node node,List<List<Integer>> ans, int level){
        if(node == null || node.children == null){
            return;
        }

        if(ans.size() - level < 1){
            ans.add(level, new ArrayList<>());
        }

        for (Node n :
                node.children) {
            ans.get(level).add(n.val);
            traverse(n, ans, level+1);
        }
    }
}
