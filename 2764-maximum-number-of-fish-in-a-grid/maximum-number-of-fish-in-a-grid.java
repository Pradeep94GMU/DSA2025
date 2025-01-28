class Solution {
    int[][] dirs = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};
    int m = 0;
    int n = 0;
    public int findMaxFish(int[][] grid) {
         m = grid.length;
         n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int maxFish = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!vis[i][j] && grid[i][j] != 0){
                    int fish = findTotalFish(grid, i, j, vis);
                    maxFish = Math.max(maxFish, fish);
                }
            }
        }

        return maxFish;
        
    }

    private int findTotalFish(int[][] grid, int i, int j, boolean[][] vis){
        vis[i][j] = true;
        int fish = 0;
        fish += grid[i][j];
        for(int[] dir: dirs){
            int nr = i + dir[0];
            int nc = j + dir[1];
            if(nr >= 0 && nr < m && nc >= 0 && nc < n && !vis[nr][nc] && grid[nr][nc] != 0){
                fish += findTotalFish(grid, nr, nc, vis);
            }
        }

        return fish;
    }
}