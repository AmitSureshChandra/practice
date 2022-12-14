// https://leetcode.com/problems/validate-binary-search-tree/description/

class Pair{
    public long max;
    public long min;
    public boolean valid;

    public Pair(boolean v){
        valid = v;
    }

    public Pair(long min, long max, boolean v){
        this.min = min;
        this.max = max;
        valid = v;
    }

    public String toString(){
        return "(" + min + ", " + max + "," + (valid ? "Yes)" : "No)");
    }
}

class Solution {
    public boolean isValidBST(TreeNode root) {
        // solution 2 => Using pairs
        // TC : O(N)
        // SC : O(1)

        return validate(root).valid;
        
    }

    public Pair validate(TreeNode node){
        if(node == null) return new Pair(2147483649l, -2147483649l, true);
        if(node.left == null && node.right == null) return new Pair(node.val, node.val, true);

        Pair left = validate(node.left);
        if(!left.valid) return new Pair(false);

        Pair right = validate(node.right);
        if(!right.valid) return new Pair(false);

        if(left.max >= node.val || right.min <= node.val)
            return new Pair(false);

        return new Pair(
            Math.min(
                left.min,
                Math.min(
                    right.min,
                    node.val
                )
            ),
            Math.max(
                left.max,
                Math.max(
                    right.max,
                    node.val
                )
            ),
            true
        );
    }
}
