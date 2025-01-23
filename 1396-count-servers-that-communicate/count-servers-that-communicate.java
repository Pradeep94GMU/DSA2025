class Solution {
    public int countServers(int[][] grid) {

        int count = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1 && canComunicate(grid, i, j)){
                    //System.out.println(i +" "+ j);
                    count++;
                }
            }
        }

        return count;
        
    }

    private boolean canComunicate(int[][] grid, int rth, int cth){
        int m = grid.length;
        int n = grid[0].length;
        //mujhe start rth row and cth col ko bas check krna hai
        for(int i = 0; i < m; i++){
            //har row ko check krna hai fix the col
            if(i == rth) continue; //c = 6
            if(grid[i][cth] == 1) 
            {
                //System.out.println(i+" "+cth);
                return true;
            }

        }

        for(int j = 0; j < n; j++){
            //har row ko check krna hai fix the col
            if(j == cth) continue;
            if(grid[rth][j] == 1) return true;

        }

        return false;

    }
}