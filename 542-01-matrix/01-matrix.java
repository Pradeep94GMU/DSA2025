class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int[][] res = new int[row][col];

        if(row * col == 1 && res[0][0] == 1){
            res[0][0] = 1;
            return res;
        }

        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(mat[i][j] == 0){ //why choose 0 , coz we can tell, nbd is near or not from 0, as we need to find the nbd of 0
                    res[i][j] = 0;
                    q.offer(new int[]{i, j});
                }else{
                    res[i][j] = Integer.MAX_VALUE; //menaing, we still need to find the dist, which is unknown 
                }
                
            }
        }

        System.out.println(Arrays.deepToString(res));

        while(!q.isEmpty()){
            int[] cell = q.poll();

            for(int[] dir: dirs){
                int nr = cell[0] + dir[0];
                int nc = cell[1] + dir[1];
                if(nr >= 0 && nr < row && nc >= 0 && nc < col){
                    //mujhe zero cell wale r and c se check krna hai parso , 
                    if(res[nr][nc] > res[cell[0]][cell[1]] + 1){
                        // + 1, matlab ki curr = 0(x) then next 0(x) + 1 hona chahiye
                        res[nr][nc] = res[cell[0]][cell[1]] + 1;
                        q.offer(new int[]{nr, nc});

                    }
                    
                    
                } 
            }
        }

        return res;
        
    }
}