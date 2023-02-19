// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();

        // q1 for ith level & q2 for holding next level elements
        q1.add(root);

        int pos = 0;

        while(!q2.isEmpty() || !q1.isEmpty()){
            LinkedList<Integer> list = new LinkedList<>();

            while(!q1.isEmpty()){
                TreeNode node = q1.remove();
                if(node == null) continue;
                if(node.left != null) q2.add(node.left);
                if(node.right != null) q2.add(node.right);

                // storing at start or last by pos
                if(pos % 2 != 0) list.addFirst(node.val);
                else list.addLast(node.val);
            }
            Queue<TreeNode> t = q1;
            q1 = q2;
            q2 = t;
            pos++;
            if(list.size() > 0) ans.add(list);
        }
        return ans;
    }
}
