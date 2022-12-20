
class Node{
    public Node one;
    public Node zero;

    public String toString(){
        return "{  \"one\" : "+ one +", \"zero\" : " + zero+ "}";
    }
}

// TC: O(N) => O(32 * N)
// SC: O(N)

// Max XOR using Trie
class Solution {
    public int findMaximumXOR(int[] nums) {
        if(nums.length == 1) return 0;
        Node node = new Node();
      
        // creating trie
        for(int i: nums)
            insert(node, i, 30);
        int max = 0;
      
        // getting max
        for(int i: nums){
            max = Math.max(max, maxXOR(node, i, 30, 0));
        }
        return max;
    }

    int maxXOR(Node node, int i, int pos, int ans){
        if(pos < 0) return ans;
        ans <<= 1;
        int t = ((1l << pos) & i) > 0 ? 1: 0;
      
        // chose opposite bit to maximize XOR
        if(t == 0){
            if(node.one != null) {
                ans |= 1;
                return maxXOR(node.one, i, pos-1, ans);
            }
            else{
                ans |= 0;
                return maxXOR(node.zero, i, pos-1, ans);
            }
        }else{
            if(node.zero != null) {
                ans |= 1;
                return maxXOR(node.zero, i, pos-1, ans);
            }
            else {
                ans |= 0;
                return maxXOR(node.one, i, pos-1, ans);
            }
        }
    }

    void insert(Node node, int i, int pos){
        if(pos < 0) return;
        if(((1l << pos) & i) > 0){
            if(node.one == null) node.one = new Node();
            insert(node.one, i, pos-1);
        }else{
            if(node.zero == null) node.zero = new Node();
            insert(node.zero, i, pos-1);
        }
    }
}
