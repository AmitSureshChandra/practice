// https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/description/

class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        if(n == 1) return 0;

        Map<Integer, List<Integer>> map = new HashMap<>();

        // creating adj map
        for(int[] a: edges){
            if(!map.containsKey(a[0])) map.put(a[0], new ArrayList<>());
            map.get(a[0]).add(a[1]);
            if(!map.containsKey(a[1])) map.put(a[1], new ArrayList<>());
            map.get(a[1]).add(a[0]);
        }

        boolean[] visited = new boolean[n];

        visited[0] = true;
        int ans = 0;
        for(int i: map.get(0)){
            ans = dfs(i, map, visited, hasApple, ans);
        }
        return ans;
    }

    int dfs(int n, Map<Integer, List<Integer>> map, boolean[] visited,List<Boolean> hasApple, int time){
        if(visited[n]) return time;
        visited[n] = true;
        
        // if no more nodes 
        if(!map.containsKey(n) || map.get(n).size() == 0) {
            if(hasApple.get(n)) return time + 2;
            return time;
        }
        int lastTime = time;
        for(int i: map.get(n)){
            // calling child
            time = dfs(i, map, visited, hasApple, time);
        }
      
        // time == lastTime comparison gives whether apples are in child node or not
        if(time == lastTime && !hasApple.get(n)) return time;
        return time + 2;
    }
}
