class Solution {
    int[][] dirs = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};
    int m = 0;
    int n = 0;
    public int findMaxFish(int[][] grid) {
         m = grid.length;
         n = grid[0].length;
        int maxFish = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] != 0){
                    int fish = findTotalFish(grid, i, j);
                    maxFish = Math.max(maxFish, fish);
                }
            }
        }

        return maxFish;
        
    }

    private int findTotalFish(int[][] grid, int i, int j){
        
        int fish = grid[i][j];
        grid[i][j] = 0;
        for(int[] dir: dirs){
            int nr = i + dir[0];
            int nc = j + dir[1];
            if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] != 0){
                fish += findTotalFish(grid, nr, nc);
            }
        }

        return fish;
    }
}