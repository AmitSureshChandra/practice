// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/description/

import java.util.SortedMap;

class Temp{

    public Temp(int l, int v){
        level = l;
        val = v;
    }
    public int level;
    public int val;
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        SortedMap<Integer, List<Temp>> map = new TreeMap<>();
        dfs(root, map, 0, 0);
        List<List<Integer>> ans = new ArrayList<>();
        
        for(Integer k: map.keySet()){
            List<Temp> l = map.get(k);
            Collections.sort(l, (v1, v2) -> {
                if(v1.level == v2.level) return v1.val - v2.val;
                return v1.level - v2.level;
            });
            ans.add(l.stream().map(i -> i.val).collect(Collectors.toList()));
        }
        
        return ans;
    }

    // traversing tree in dfs & storing element by left to right & with depth 
    void dfs(TreeNode node, SortedMap<Integer, List<Temp>> map, int l, int d){
        if(node == null) return;
        if(!map.containsKey(l)) map.put(l, new ArrayList<>());
        map.get(l).add(new Temp(d, node.val));
        dfs(node.left, map, l-1, d+1);
        dfs(node.right, map, l+1, d+1);
    }

}
