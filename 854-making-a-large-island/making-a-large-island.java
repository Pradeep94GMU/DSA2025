class Solution {
    int[][] dirs = {{0, 1}, {0 ,- 1}, { 1, 0}, {-1, 0}};
    public int largestIsland(int[][] grid) {
        //pahle ek dfs maar ke , i will store the maxium largest island 
        int largetIsland = 0;
        int n = grid.length;
        //Queue<int[]> q = new LinkedList();
        int[][] vis = new int[n][n];
        HashMap<Integer, Integer> isLandId = new HashMap();
        // Assign ids to each island and record their sizes
        largetIsland = assignIdToEachIslan(grid, n,isLandId, vis);

        //yaha tak mere pass, largetsIsnad updat eho gya plus map bhi update ho gya
        int res = largetIsland;
         boolean hasZero = false;
        //for each zero cell we do something
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    hasZero = true;
                    //now for each 0 we check all 4 direct and find the i and j and check what is id for this i and j in vis
                    //then using that id we can get size from map and check with max
                    HashSet<Integer> set = new HashSet();
                    for(int[] dir: dirs){
                        int nr = i + dir[0];
                        int nc = j + dir[1];
                        if(nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 1){
                            set.add(vis[nr][nc]);
                        }
                        
                    }

                    int sum = 1;
                    for(int eachId : set){
                        sum  += isLandId.getOrDefault(eachId, 0);
                    }

                    res = Math.max(res, sum);
                }
            }
        }

        return hasZero ? res : n * n;
        
    }

    private int assignIdToEachIslan(int[][] grid, int n, HashMap<Integer, Integer> isLandId, int[][] vis){

        int groupId = 1;
        int largetIsland = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(vis[i][j] == 0 && grid[i][j] == 1){
                    //dfs call kr skte hai
                    int sizeOfIsland = dfs(grid, vis, i, j, groupId, n);
                    isLandId.put(groupId, sizeOfIsland);
                    largetIsland = Math.max(largetIsland, sizeOfIsland);
                    groupId++;
                }
            }
        }
        return largetIsland;

    }


    private int dfs(int[][] grid, int[][] vis, int i, int j,int groupId, int n){
        if(i < 0 || i >= n || j < 0 || j >= n || vis[i][j] != 0 || grid[i][j] == 0){
                return 0;
        }

        //vis[i][j] = true;   //rather than saving this true, save as groupId
        vis[i][j] = groupId; 

        int count = 1;
        for(int[] dir: dirs){
            count += dfs(grid, vis, i + dir[0], j + dir[1], groupId, n);
        }

        return count;

    }
}