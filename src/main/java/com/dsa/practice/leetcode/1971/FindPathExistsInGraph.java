// https://leetcode.com/problems/find-if-path-exists-in-graph/description/

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        if(edges.length == 0 && source != destination) return false;
        if(edges.length == 0 && source == destination) return true;
        for(int[] a: edges){
          
            // adding edge
            if(!map.containsKey(a[0])) map.put(a[0], new ArrayList<>());
            if(!map.containsKey(a[1])) map.put(a[1], new ArrayList<>());
            map.get(a[0]).add(a[1]); 
            map.get(a[1]).add(a[0]);   
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        visited[source] = true;
        q.add(source);

        // BFS 
        while(!q.isEmpty()){

            // check if destination node reached return true
            int node = q.poll();
            visited[node] = true;
            if(node == destination) return true;
            for(int i: map.get(node)){
                if(!visited[i]) q.add(i);
            }
        }
        return false;
    }
}
