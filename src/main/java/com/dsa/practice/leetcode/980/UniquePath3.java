// https://leetcode.com/problems/unique-paths-iii/description/

class Solution {
    public int uniquePathsIII(int[][] grid) {
        int r = grid.length, c = grid[0].length, x1 = -1, y1 = -1;
        
        // finds start point
        for(int i=0; i< r; i++){
            for(int j=0; j< c; j++){
                if(grid[i][j] == 1) {
                    x1 = i;
                    y1 = j;
                    break;
                }
            }
        }

        return path(x1, y1, r, c, grid, new boolean[r][c]);
    }
    
    // check if all nodes visited
    boolean checkAllVisited(int[][] grid, boolean[][] visited){
        for(int i=0; i< grid.length; i++){
            for(int j=0; j< grid[0].length; j++){
                if(grid[i][j] == 0 && !visited[i][j]) return false;
            }
        }
        return true;
    }

    int path(int x, int y, int r, int c, int[][] grid, boolean[][] visited){
        if(x < 0 || x >= r || y < 0 || y >= c || visited[x][y]) return 0;  
        if(grid[x][y] == 2 && checkAllVisited(grid, visited)) { return 1; }
      
        // if block found
        if(grid[x][y] == -1) return 0;
        visited[x][y] = true;

        int ans = path(x+1, y, r, c, grid, visited) + 
                   path(x-1, y, r, c, grid, visited) + 
                   path(x, y+1, r, c, grid, visited) + 
                   path(x, y-1, r, c, grid, visited);

        visited[x][y] = false;
        return ans;
    }
}
